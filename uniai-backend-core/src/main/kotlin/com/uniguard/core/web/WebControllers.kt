package com.uniguard.core.web

import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/api/v1/licenses")
class LicenseController {
    
    @GetMapping("/{keyCode}")
    fun getLicense(@PathVariable keyCode: String): Mono<Map<String, String>> {
        return Mono.just(mapOf("status" to "MINTED", "keyCode" to keyCode))
    }

    @PostMapping("/transfer")
    fun transferLicense(@RequestBody payload: Map<String, String>): Mono<Map<String, String>> {
        return Mono.just(mapOf("status" to "TRANSFERRED"))
    }
}

@RestController
@RequestMapping("/api/v1/devices")
class DeviceOnboardingController {
    
    @PostMapping("/onboard")
    fun onboardDevice(@RequestBody payload: Map<String, String>): Mono<Map<String, String>> {
        return Mono.just(mapOf("status" to "ONBOARDED", "deviceId" to "dummy-uuid"))
    }
}

@RestController
@RequestMapping("/api/v1/payments")
class PaymentWebhookController {
    
    private val processedEventIds = java.util.concurrent.ConcurrentHashMap.newKeySet<String>()

    @PostMapping("/webhook")
    fun handleWebhook(
        @RequestHeader("X-Signature") signature: String,
        @RequestBody payload: String
    ): Mono<Map<String, String>> {
        val secret = "my-webhook-secret"

        return Mono.fromCallable {
            val mac = javax.crypto.Mac.getInstance("HmacSHA256")
            mac.init(javax.crypto.spec.SecretKeySpec(secret.toByteArray(Charsets.UTF_8), "HmacSHA256"))
            val computedSignature = mac.doFinal(payload.toByteArray(Charsets.UTF_8))
                .joinToString("") { "%02x".format(it) }

            if (signature != computedSignature) {
                throw org.springframework.web.server.ResponseStatusException(
                    org.springframework.http.HttpStatus.UNAUTHORIZED, "Invalid signature"
                )
            }

            val eventId = try {
                val json = com.fasterxml.jackson.module.kotlin.jacksonObjectMapper().readTree(payload)
                json.get("id")?.asText() ?: java.util.UUID.randomUUID().toString()
            } catch (e: Exception) {
                java.util.UUID.randomUUID().toString()
            }

            if (!processedEventIds.add(eventId)) {
                mapOf("status" to "ALREADY_PROCESSED")
            } else {
                mapOf("status" to "ACKNOWLEDGED")
            }
        }
    }
}

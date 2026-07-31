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
    
    @PostMapping("/webhook")
    fun handleWebhook(@RequestBody payload: Map<String, Any>): Mono<Map<String, String>> {
        return Mono.just(mapOf("status" to "ACKNOWLEDGED"))
    }
}

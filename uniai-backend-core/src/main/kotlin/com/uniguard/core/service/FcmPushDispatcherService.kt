package com.uniguard.core.service

import org.springframework.stereotype.Service
import reactor.core.publisher.Mono

@Service
class FcmPushDispatcherService {

    fun sendRemoteLockUnlock(deviceId: String, action: String): Mono<Boolean> {
        // Implement instant remote lock/unlock FCM push payload sending
        println("Sending \$action FCM payload to device: \$deviceId")
        
        // Mocking the web client or FCM admin SDK call
        return Mono.just(true)
    }
}

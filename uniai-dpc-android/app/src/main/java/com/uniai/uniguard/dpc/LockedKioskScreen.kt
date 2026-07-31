package com.uniai.uniguard.dpc

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.journeyapps.barcodescanner.BarcodeEncoder
import com.google.zxing.BarcodeFormat

@Composable
fun LockedKioskScreen(upiId: String = "example@upi", phoneNumber: String = "1234567890") {
    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text("Device Locked by UniGuard Pro")
        Spacer(modifier = Modifier.height(16.dp))

        // UPI QR Code Generator
        val bitmap = generateQRCode("upi://pay?pa=$upiId&pn=UniGuard&am=1.00&cu=INR")
        if (bitmap != null) {
            Image(
                bitmap = bitmap.asImageBitmap(),
                contentDescription = "UPI QR Code",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 1-Tap Call Launcher
        Button(onClick = {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            context.startActivity(intent)
        }) {
            Text("Call Support")
        }
    }
}

fun generateQRCode(content: String): Bitmap? {
    return try {
        val barcodeEncoder = BarcodeEncoder()
        barcodeEncoder.encodeBitmap(content, BarcodeFormat.QR_CODE, 400, 400)
    } catch (e: Exception) {
        null
    }
}

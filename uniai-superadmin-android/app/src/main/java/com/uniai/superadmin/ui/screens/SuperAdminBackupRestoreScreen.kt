package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class BackupSnapshot(
    val id: String,
    val timestamp: String,
    val size: String,
    val type: String,
    val location: String,
    val status: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminBackupRestoreScreen() {
    var isBackingUp by remember { mutableStateOf(false) }

    val snapshots = listOf(
        BackupSnapshot("SNAP-2026-0802-01", "Today, 17:30:00 UTC", "4.2 GB", "AUTOMATED DAILY", "AWS S3 us-east-1", "HEALTHY"),
        BackupSnapshot("SNAP-2026-0801-01", "Yesterday, 00:00:00 UTC", "4.1 GB", "AUTOMATED DAILY", "AWS S3 us-east-1", "HEALTHY"),
        BackupSnapshot("SNAP-2026-0731-02", "31 Jul 2026, 12:00:00 UTC", "4.0 GB", "MANUAL SNAPSHOT", "Cold Storage Vault", "VERIFIED"),
        BackupSnapshot("SNAP-2026-0725-01", "25 Jul 2026, 00:00:00 UTC", "3.8 GB", "WEEKLY FULL DUMP", "Cloudflare R2 Bucket", "HEALTHY")
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp)
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier.fillMaxSize()
        ) {
            // Header
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "DISASTER RECOVERY CENTER",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Backup & Restore",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }

                    Button(
                        onClick = { isBackingUp = true },
                        colors = ButtonDefaults.buttonColors(containerColor = SolarAmber, contentColor = ObsidianBackground),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.CloudUpload, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Create Snapshot", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Backup Health Card
            item {
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, EmeraldGreen.copy(alpha = 0.4f))
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text("LAST COMPLETED BACKUP", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = EmeraldGreen)
                            Text("1 Hour Ago (SNAP-2026-0802-01)", fontSize = 14.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)
                            Text("Destination: AWS S3 Encrypted Bucket • 4.2 GB", fontSize = 10.sp, color = TextSecondary)
                        }

                        Box(
                            modifier = Modifier
                                .size(40.dp)
                                .clip(CircleShape)
                                .background(EmeraldGreen.copy(alpha = 0.15f)),
                            contentAlignment = Alignment.Center
                        ) {
                            Icon(Icons.Default.CheckCircle, contentDescription = null, tint = EmeraldGreen, modifier = Modifier.size(22.dp))
                        }
                    }
                }
            }

            // Snapshot Vault Stream
            item {
                Text("AVAILABLE SYSTEM SNAPSHOTS", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = SolarAmber)
            }

            items(snapshots) { snap ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, ObsidianCardBorder)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(14.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
                            Icon(Icons.Default.Storage, contentDescription = null, tint = NeonCyan, modifier = Modifier.size(24.dp))
                            Column {
                                Text(snap.id, fontSize = 13.sp, fontWeight = FontWeight.Bold, color = Color.White)
                                Text("${snap.type} • ${snap.size}", fontSize = 10.sp, color = TextSecondary)
                                Text(snap.timestamp, fontSize = 10.sp, color = NeonCyan)
                            }
                        }

                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(containerColor = CrimsonRed.copy(alpha = 0.15f), contentColor = CrimsonRed),
                            shape = RoundedCornerShape(8.dp),
                            contentPadding = PaddingValues(horizontal = 10.dp, vertical = 4.dp)
                        ) {
                            Text("RESTORE", fontSize = 10.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

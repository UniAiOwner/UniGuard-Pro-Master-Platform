package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uniai.superadmin.ui.theme.*

data class RolePreset(
    val title: String,
    val permissionsCount: String,
    val userCount: String,
    val isRoot: Boolean,
    val color: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminRoleManagementScreen() {
    val roles = listOf(
        RolePreset("SuperAdmin (Root Master)", "All 48 Permissions", "3 Users", true, CrimsonRed),
        RolePreset("Territory Distributor Admin", "32 Permissions", "14 Users", false, SolarAmber),
        RolePreset("Retailer POS Agent", "12 Permissions", "842 Users", false, EmeraldGreen),
        RolePreset("Security & Recovery Officer", "18 Permissions", "26 Users", false, NeonCyan)
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
            // Header Bar with Create Button
            item {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Column {
                        Text(
                            text = "ROLE-BASED ACCESS CONTROL (RBAC)",
                            fontSize = 11.sp,
                            fontWeight = FontWeight.ExtraBold,
                            color = NeonCyan,
                            letterSpacing = 1.5.sp
                        )
                        Text(
                            text = "Role Management",
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Black,
                            color = Color.White
                        )
                    }

                    Button(
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(containerColor = SolarAmber, contentColor = ObsidianBackground),
                        shape = RoundedCornerShape(12.dp),
                        contentPadding = PaddingValues(horizontal = 12.dp, vertical = 6.dp)
                    ) {
                        Icon(Icons.Default.Add, contentDescription = null, modifier = Modifier.size(16.dp))
                        Spacer(modifier = Modifier.width(4.dp))
                        Text("Create Role", fontSize = 11.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }

            // Role Presets List
            items(roles) { r ->
                Surface(
                    modifier = Modifier.fillMaxWidth(),
                    color = ObsidianCard,
                    shape = RoundedCornerShape(16.dp),
                    border = androidx.compose.foundation.BorderStroke(1.dp, r.color.copy(alpha = 0.4f))
                ) {
                    Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(r.title, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                            if (r.isRoot) {
                                Surface(color = CrimsonRed.copy(alpha = 0.15f), shape = RoundedCornerShape(6.dp)) {
                                    Text("SOVEREIGN ROOT", fontSize = 9.sp, fontWeight = FontWeight.Bold, color = CrimsonRed, modifier = Modifier.padding(horizontal = 6.dp, vertical = 2.dp))
                                }
                            }
                        }
                        HorizontalDivider(color = Color.White.copy(alpha = 0.05f))
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text("Assigned Users: ${r.userCount}", fontSize = 11.sp, color = TextSecondary)
                            Text(r.permissionsCount, fontSize = 11.sp, color = r.color, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }
        }
    }
}

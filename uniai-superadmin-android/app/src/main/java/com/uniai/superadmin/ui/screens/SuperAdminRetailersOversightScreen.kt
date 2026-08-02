package com.uniai.superadmin.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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

data class RetailerItem(
    val shopName: String,
    val merchantName: String,
    val distributor: String,
    val city: String,
    val deviceVolume: String,
    val activeKeys: String,
    val status: String,
    val statusColor: Color
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SuperAdminRetailersOversightScreen(
    onNavigateToRetailerDetail: (String) -> Unit = {}
) {
    var searchQuery by remember { mutableStateOf("") }

    val sampleRetailers = listOf(
        RetailerItem("Premium Wireless", "Rajesh Gupta", "Surya Telecom Master", "Agra, UP", "4,520", "4,100", "ACTIVE", EmeraldGreen),
        RetailerItem("Metro Mobiles", "Anil Mehta", "Vardhman Wholesale", "Noida, UP", "2,840", "2,650", "ACTIVE", EmeraldGreen),
        RetailerItem("City Communications", "Pankaj Sharma", "Surya Telecom Master", "Mathura, UP", "1,920", "1,400", "SUSPENDED", CrimsonRed),
        RetailerItem("Royal Mobile Shop", "Deepak Verma", "Apex Mobile Hub", "Jaipur, RJ", "3,110", "2,980", "ACTIVE", EmeraldGreen)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ObsidianBackground)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(14.dp)
    ) {
        // 1. Header
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "MERCHANT POS DIRECTORY",
                    fontSize = 11.sp,
                    fontWeight = FontWeight.ExtraBold,
                    color = NeonCyan,
                    letterSpacing = 1.5.sp
                )
                Text(
                    text = "Retailers Oversight",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Black,
                    color = Color.White
                )
            }
            Surface(
                color = NeonCyan.copy(alpha = 0.12f),
                shape = RoundedCornerShape(12.dp),
                border = androidx.compose.foundation.BorderStroke(1.dp, NeonCyan.copy(alpha = 0.4f))
            ) {
                Text(
                    text = "1,890 POS SHOPS",
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Bold,
                    color = NeonCyan,
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 4.dp)
                )
            }
        }

        // 2. Search Field
        OutlinedTextField(
            value = searchQuery,
            onValueChange = { searchQuery = it },
            placeholder = { Text("Search Shop Name, Merchant, City...", color = TextSecondary, fontSize = 12.sp) },
            leadingIcon = { Icon(Icons.Default.Search, contentDescription = null, tint = TextSecondary) },
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(14.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = NeonCyan,
                unfocusedBorderColor = ObsidianCardBorder,
                focusedContainerColor = ObsidianCard,
                unfocusedContainerColor = ObsidianCard,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White
            )
        )

        // 3. Summary Count Chips
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SummaryChipTile(modifier = Modifier.weight(1f), title = "Total POS", value = "1,890", color = Color.White)
            SummaryChipTile(modifier = Modifier.weight(1f), title = "Active Shops", value = "1,780", color = EmeraldGreen)
            SummaryChipTile(modifier = Modifier.weight(1f), title = "Suspended", value = "110", color = CrimsonRed)
        }

        // 4. Retailer List Cards
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.weight(1f)
        ) {
            items(sampleRetailers) { retailer ->
                RetailerMerchantCard(retailer = retailer, onClick = { onNavigateToRetailerDetail(retailer.shopName) })
            }
        }
    }
}

@Composable
fun SummaryChipTile(
    modifier: Modifier = Modifier,
    title: String,
    value: String,
    color: Color
) {
    Surface(
        modifier = modifier,
        color = ObsidianCard,
        shape = RoundedCornerShape(12.dp),
        border = androidx.compose.foundation.BorderStroke(1.dp, color.copy(alpha = 0.3f))
    ) {
        Column(
            modifier = Modifier.padding(10.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(value, fontSize = 15.sp, fontWeight = FontWeight.Black, color = color)
            Text(title, fontSize = 9.sp, color = TextSecondary, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun RetailerMerchantCard(
    retailer: RetailerItem,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
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
            Row(
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(42.dp)
                        .clip(CircleShape)
                        .background(retailer.statusColor.copy(alpha = 0.15f)),
                    contentAlignment = Alignment.Center
                ) {
                    Icon(Icons.Default.Storefront, contentDescription = null, tint = retailer.statusColor, modifier = Modifier.size(22.dp))
                }
                Column {
                    Text(retailer.shopName, fontSize = 14.sp, fontWeight = FontWeight.Bold, color = Color.White)
                    Text("Owner: ${retailer.merchantName} • ${retailer.city}", fontSize = 11.sp, color = TextSecondary)
                    Text("Distributor: ${retailer.distributor}", fontSize = 10.sp, color = SolarAmber, fontWeight = FontWeight.SemiBold)
                }
            }

            Column(horizontalAlignment = Alignment.End) {
                Surface(
                    color = retailer.statusColor.copy(alpha = 0.15f),
                    shape = RoundedCornerShape(8.dp)
                ) {
                    Text(
                        text = retailer.status,
                        fontSize = 10.sp,
                        fontWeight = FontWeight.Bold,
                        color = retailer.statusColor,
                        modifier = Modifier.padding(horizontal = 8.dp, vertical = 3.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text("${retailer.deviceVolume} Devices", fontSize = 11.sp, fontWeight = FontWeight.Bold, color = Color.White)
            }
        }
    }
}

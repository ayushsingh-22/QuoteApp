package com.example.quotes.screen

import android.content.Intent
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FormatQuote
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.DataManager
import com.example.quotes.R
import com.example.quotes.quoteData


@Composable
fun QuoteScreen(quoteData: quoteData?) {

    val context = LocalContext.current

    BackHandler { DataManager.SwitchPages(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.linearGradient(
                    colors = listOf(
                        colorResource(id = R.color.Mint),
                        colorResource(id = R.color.custom_yellow),
                        colorResource(id = R.color.orange),
                    )
                )
            ),
        contentAlignment = Alignment.Center
    ) {
        Card(
            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.light_red),
            ),
            modifier = Modifier
                .padding(15.dp)
                .fillMaxWidth(),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),
            shape = RectangleShape
        ) {
            Column(Modifier.padding(15.dp)) {
                Icon(
                    imageVector = Icons.Default.FormatQuote,
                    tint = Color.Black,
                    contentDescription = "Quote Icon",
                    modifier = Modifier
                        .rotate(180F)
                        .size(80.dp),
                )

                if (quoteData != null) {
                    Text(
                        text = quoteData.quote,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Normal,
                        color = Color.Black
                    )
                }

                HorizontalDivider(
                    modifier = Modifier.height(10.dp),
                    color = colorResource(id = R.color.orange),
                    thickness = 6.dp,
                )
                Spacer(modifier = Modifier.height(5.dp))

                quoteData?.let {
                    Text(
                        text = it.author,
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black
                    )
                }

                IconButton(
                    onClick = {
                        quoteData?.let {
                            val shareIntent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "${it.quote} - ${it.author}")
                                type = "text/plain"
                            }
                            context.startActivity(Intent.createChooser(shareIntent, "Share via"))
                        }
                    },
                    modifier = Modifier.align(Alignment.End)
                ) {
                    Icon(imageVector = Icons.Default.Share,
                        tint = Color.Black,
                        contentDescription = "Share Icon")
                }
            }
        }
    }
}

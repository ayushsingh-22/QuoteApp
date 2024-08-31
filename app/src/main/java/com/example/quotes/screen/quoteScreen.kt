package com.example.quotes.screen

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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.Quotes
import com.example.quotes.R


@Composable
fun QuoteScreen(quotes: Quotes) {

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
                    contentDescription = "Quote Icon",
                    Modifier
                        .rotate(180F)
                        .size(80.dp),
                )

                Text(
                    text = quotes.quote,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Normal,
                )

                HorizontalDivider(
                    modifier = Modifier.height(10.dp),
                    color = colorResource(id = R.color.orange),
                    thickness = 6.dp,
                )
                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = quotes.author,
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold,
                )

            }
        }
    }
}

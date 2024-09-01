package com.example.quotes.screen


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.quotes.Quotes
import com.example.quotes.R

@Composable
fun QuoteList(quotes: Quotes, onClick: (quotes: Quotes) -> Unit)  {

        Card(

            colors = CardDefaults.cardColors(
                containerColor = colorResource(id = R.color.light_red),
            ),
            modifier = Modifier
                .padding(5.dp, top = 25.dp)
                .fillMaxWidth()
                .clickable { onClick
                           },
            elevation = CardDefaults.cardElevation(
                defaultElevation = 10.dp
            ),

            shape = RectangleShape
        ) {
            Column(Modifier.padding(8.dp)) {

                Icon(    modifier =  Modifier
                    .rotate(180F)
                    .size(30.dp),
                    imageVector = Icons.Default.FormatQuote,
                    contentDescription = "Quote Icon",
                    tint = colorResource(id = R.color.black),

                )

                Text(
                    text = quotes.quote,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color  = colorResource(id = R.color.black)
                )

                HorizontalDivider(
                    modifier = Modifier.height(10.dp),
                    color = colorResource(id = R.color.orange),
                    thickness = 6.dp,
                )

                Spacer(modifier = Modifier.height(5.dp))

                Text(
                    text = quotes.author,
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color  = colorResource(id = R.color.black)
                )

            }
        }
    }

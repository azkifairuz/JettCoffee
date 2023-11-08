package com.azkifairuz.jetcoffee.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFromBaseline
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.azkifairuz.jetcoffee.Categories
import com.azkifairuz.jetcoffee.R
import com.azkifairuz.jetcoffee.ui.theme.JetCoffeeTheme

@Composable
fun CategoryItem(
    categories: Categories,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = categories.imageCategory),
            contentDescription = null,
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape)
        )
        Text(
            text = stringResource(id = categories.textCategory),
            fontSize = 10.sp,
            modifier = Modifier.paddingFromBaseline(
                top = 16.dp,
                bottom = 8.dp
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun CategoryItemPrev() {
    JetCoffeeTheme {
        CategoryItem(
            Categories(
                R.drawable.icon_category_cappuccino,
                R.string.category_cappuccino,
            ),
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

package com.azkifairuz.jetcoffee

import Search
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.azkifairuz.jetcoffee.ui.components.CategoryItem
import com.azkifairuz.jetcoffee.ui.theme.JetCoffeeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetCoffeeTheme {
                JetCoffeeApp()
            }
        }
    }
}


@Composable
fun JetCoffeeApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {

    }
}

//home
@Composable
fun Home(modifier: Modifier = Modifier) {
        Column {
            Banner()
            SectionText(title = stringResource(R.string.section_category))
            CategoryRow()
        }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    JetCoffeeTheme {
        Home()
    }
}
// end home


@Composable
fun Banner(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner),
            contentDescription = "banner",
            contentScale = ContentScale.Crop,
            modifier = modifier
                .height(180.dp)
        )
        Search(modifier = modifier.padding(8.dp))
    }
}

@Composable
fun SectionText(
    title : String,
    modifier: Modifier = Modifier
) {
    Text(
        text = title,
        style = MaterialTheme.typography.headlineSmall.copy(
            fontWeight = FontWeight.ExtraBold
        ),
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
    )
    
}

@Composable
fun CategoryRow(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(vertical = 16.dp)
    ){
        items(dummyCategory,key = {it.textCategory}){ category ->
            CategoryItem(categories = category)
        }
    }
    
}


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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
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
import com.azkifairuz.jetcoffee.ui.components.MenuItem
import com.azkifairuz.jetcoffee.ui.model.Menus
import com.azkifairuz.jetcoffee.ui.model.dummyBestSellerMenu
import com.azkifairuz.jetcoffee.ui.model.dummyCategory
import com.azkifairuz.jetcoffee.ui.model.dummyMenu
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
    Column(Modifier.verticalScroll(rememberScrollState())) {
        Banner()
        Home(
            title = stringResource(id = R.string.section_category),
            content = { CategoryRow()}
        )
        Home(
            title = stringResource(id = R.string.section_favorite_menu),
            content = { MenuRow(dummyMenu) }
        )
        Home(
            title = stringResource(id = R.string.section_best_seller_menu),
            content = { MenuRow(dummyBestSellerMenu) }
        )

    }
}

//home
@Composable
fun Home(
    title:String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        SectionText(title = title,modifier)
        content()
    }
}

@Preview(showBackground = true)
@Composable
fun HomePreview() {
    JetCoffeeTheme {
        JetCoffeeApp()
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

@Composable
fun MenuRow(
    listMenu: List<Menus>,
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier.padding(vertical = 16.dp)
    ){
        items(listMenu,key = {it.title}){ menu ->
            MenuItem(menus = menu)
        }
    }

}


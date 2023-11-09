package com.azkifairuz.jetcoffee.ui.model

import com.azkifairuz.jetcoffee.R

data class Menus(
    val image: Int,
    val title: String,
    val price: String,
)

val dummyMenu = listOf(
    Menus(R.drawable.menu1, "Tiramisu Coffee Milk", "Rp 28.000"),
    Menus(R.drawable.menu2, "Pumpkin Spice Latte", "Rp 18.000"),
    Menus(R.drawable.menu3, "Light Cappuccino", "Rp 20.000"),
    Menus(R.drawable.menu4, "Choco Creamy Latte", "Rp 16.000"),
)

val dummyBestSellerMenu = dummyMenu.shuffled()

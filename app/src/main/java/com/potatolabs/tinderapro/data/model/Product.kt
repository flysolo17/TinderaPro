package com.potatolabs.tinderapro.data.model




data class Product(
    val id : String = "",
    val barcode : String = "",
    val image : String ? = null,
    val name : String = "",
    val brand : String = "",
    val category : String = "",
    val stock : Int = 0,
    val price : Long = 0L,
    val cost : Long = 0L,
    val stockAlert : StockAlert? = null,
    val isActive : Boolean = true,
    val createdAt : Long = System.currentTimeMillis(),
    val updatedAt : Long = System.currentTimeMillis()
)

data class StockAlert(
    val enabled : Boolean = false,
    val min : Int = 5
)
package com.potatolabs.tinderapro.data.model



data class Transaction(
    val id : String,
    val storeInfo : Store? = null,
    val items : List<Items> = emptyList(),
    val total : Long= 0L,
    val createdAt : Long = System.currentTimeMillis()
)

data class Items(
    val pid : String = "",
    val name : String = "",
    val image : String = "",
    val price : Long = 0L,

)
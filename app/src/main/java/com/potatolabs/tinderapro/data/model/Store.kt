package com.potatolabs.tinderapro.data.model

data class Store(
    val id: String = "",
    val name: String = "",
    val logo: String? = null,
    val address: String = "",
    val tin: String = "",
    val createdAt: Long = System.currentTimeMillis(),
    val updatedAt: Long = System.currentTimeMillis()
)
package com.potatolabs.tinderapro.data.model



data class User(
    val id: String = "",
    val sid: String = "",
    val name: String = "",
    val email: String = "",
    val createdAt : Long = System.currentTimeMillis(),
    val updatedAt : Long = System.currentTimeMillis()
)


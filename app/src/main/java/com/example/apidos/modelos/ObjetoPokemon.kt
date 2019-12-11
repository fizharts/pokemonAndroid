package com.example.apidos.modelos

data class ObjetoPokemon(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: ArrayList<Result>
)

data class Result(
    val name: String,
    val url: String
)
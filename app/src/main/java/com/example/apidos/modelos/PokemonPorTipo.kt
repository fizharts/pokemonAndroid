package com.example.apidos.modelos

data class PokemonPorTipo(
    val damage_relations: DamageRelations,
    val game_indices: List<GameIndice>,
    val generation: GenerationX,
    val id: Int,
    val move_damage_class: MoveDamageClass,
    val moves: List<Move>,
    val name: String,
    val names: List<Name>,
    val pokemon: List<Pokemon>
)

data class DamageRelations(
    val double_damage_from: List<DoubleDamageFrom>,
    val double_damage_to: List<Any>,
    val half_damage_from: List<Any>,
    val half_damage_to: List<HalfDamageTo>,
    val no_damage_from: List<NoDamageFrom>,
    val no_damage_to: List<NoDamageTo>
)

data class DoubleDamageFrom(
    val name: String,
    val url: String
)

data class HalfDamageTo(
    val name: String,
    val url: String
)

data class NoDamageFrom(
    val name: String,
    val url: String
)

data class NoDamageTo(
    val name: String,
    val url: String
)

data class GameIndice(
    val game_index: Int,
    val generation: Generation
)

data class Generation(
    val name: String,
    val url: String
)

data class GenerationX(
    val name: String,
    val url: String
)

data class MoveDamageClass(
    val name: String,
    val url: String
)

data class Move(
    val name: String,
    val url: String
)

data class Name(
    val language: Language,
    val name: String
)

data class Language(
    val name: String,
    val url: String
)

data class Pokemon(
    val pokemon: PokemonX,
    val slot: Int
)

data class PokemonX(
    val name: String,
    val url: String
)
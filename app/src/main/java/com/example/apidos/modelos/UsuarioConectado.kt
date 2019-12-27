package com.example.apidos.modelos

data class UsuarioConectado(
    val relacion: Relacion
)

data class Relacion(
    val empresa: Empresa,
    val estatus: Int,
    val id: Int,
    val perfil: Perfil,
    val persona: Persona
)

data class Empresa(
    val direccion: Direccion,
    val id: Int,
    val nombre: String,
    val razon_social: String,
    val rfc: String
)

data class Direccion(
    val calle: String,
    val colonia: Any,
    val exterior: String,
    val id: Int,
    val interior: String
)

data class Perfil(
    val id: Int,
    val nombre: String
)

data class Persona(
    val celular: String,
    val curp: String,
    val direccion: DireccionX,
    val email: String,
    val id: Int,
    val materno: String,
    val numero_identificacion: String,
    val paterno: String,
    val primer_nombre: String,
    val rfc: String,
    val segundo_nombre: String,
    val telefono: String,
    val tipo_identificacion: TipoIdentificacion
)

data class DireccionX(
    val calle: String,
    val colonia: Any,
    val exterior: String,
    val id: Int,
    val interior: String
)

data class TipoIdentificacion(
    val id: Int,
    val nombre: String
)
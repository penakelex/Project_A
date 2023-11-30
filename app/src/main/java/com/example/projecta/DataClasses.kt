package com.example.projecta

import kotlinx.serialization.Serializable

@Serializable
data class EventCreate(
    val organizers: Array<UInt>,
    val name: String,
    val start: ULong,
    val end: ULong,
    val description: String,
    val picture: String,
    val participants: Array<UInt>?
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventCreate

        if (!organizers.contentEquals(other.organizers)) return false
        if (name != other.name) return false
        if (start != other.start) return false
        if (end != other.end) return false
        if (description != other.description) return false
        if (picture != other.picture) return false
        if (participants != null) {
            if (other.participants == null) return false
            if (!participants.contentEquals(other.participants)) return false
        } else if (other.participants != null) return false

        return true
    }

    override fun hashCode(): Int {
        var result = organizers.contentHashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + start.hashCode()
        result = 31 * result + end.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + picture.hashCode()
        result = 31 * result + (participants?.contentHashCode() ?: 0)
        return result
    }
}

@Serializable
data class EventEdit(
    val id: UInt,
    val organizers: Array<UInt>?,
    val name: String?,
    val start: ULong?,
    val end: ULong?,
    val description: String?,
    val picture: String?,
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EventEdit

        if (id != other.id) return false
        if (organizers != null) {
            if (other.organizers == null) return false
            if (!organizers.contentEquals(other.organizers)) return false
        } else if (other.organizers != null) return false
        if (name != other.name) return false
        if (start != other.start) return false
        if (end != other.end) return false
        if (description != other.description) return false
        return picture == other.picture
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + (organizers?.contentHashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (start?.hashCode() ?: 0)
        result = 31 * result + (end?.hashCode() ?: 0)
        result = 31 * result + (description?.hashCode() ?: 0)
        result = 31 * result + (picture?.hashCode() ?: 0)
        return result
    }
}

@Serializable
data class Events(
    val organizers: Array<UInt>,
    val name: String,
    val start: ULong,
    val end: ULong,
    val description: String,
    val picture: String
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Events

        if (!organizers.contentEquals(other.organizers)) return false
        if (name != other.name) return false
        if (start != other.start) return false
        if (end != other.end) return false
        if (description != other.description) return false
        return picture == other.picture
    }

    override fun hashCode(): Int {
        var result = organizers.contentHashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + start.hashCode()
        result = 31 * result + end.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + picture.hashCode()
        return result
    }
}

@Serializable
data class UserRegister(
    val code: String,
    val phone: String?,
    val email: String?,
    val password: String,
    val name: String,
    val surname: String,
    val patronymic: String,
    val status: String
)

@Serializable
data class UserLogin(
    val phone: String?,
    val email: String?,
    val password: String
)

@Serializable
data class UserUpdate(
    val phone: String?,
    val name: String?,
    val surname: String?,
    val patronymic: String?,
    val status: String?
)

@Serializable
data class User(
    val phone: String?,
    val email: String?,
    val name: String,
    val surname: String,
    val patronymic: String,
    val status: String
)

@Serializable
data class Response<out Type>(
    val result: ResultResponse,
    val data: Type? = null
)

@Serializable
data class ResultResponse(
    val statusCode: Short,
    val message: String
)
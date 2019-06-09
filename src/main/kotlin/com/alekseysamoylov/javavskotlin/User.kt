package com.alekseysamoylov.javavskotlin


class User(private var id: Long, private var name: String) {

    fun getId(): Long = id
    fun getName(): String = name

    override fun toString(): String {
        return "User(id=$id, name='$name')"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as User

        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}

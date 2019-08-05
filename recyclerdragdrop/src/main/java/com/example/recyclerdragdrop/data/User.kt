package com.example.recyclerdragdrop.data

internal data class User(val id: Int, val name: String,
                         val imageUrl: String, val type: String) {

    constructor(user: User) : this(user.id, user.name, user.imageUrl, user.type)
}
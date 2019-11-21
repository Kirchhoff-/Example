package com.example.recyclerdragdrop.data

internal data class User(
    val id: Int,
    val name: String,
    val imageUrl: String,
    val type: String
) {

    constructor(name: String, imageUrl: String, type: String) : this(generateUserId(), name, imageUrl, type)

    constructor(type: String) : this(generateUserId(), "", "", type)

    constructor(user: User) : this(user.id, user.name, user.imageUrl, user.type)

    companion object {
        private var userId = -1

        private fun generateUserId(): Int {
            userId += 1
            return userId
        }
    }
}

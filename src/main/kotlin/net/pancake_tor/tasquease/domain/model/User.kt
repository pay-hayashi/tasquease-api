package net.pancake_tor.tasquease.domain.model

import lombok.Value

@Value
class User(
    val id: Int,
    val userId: String,
    val userName: String,
    val email: String,
)

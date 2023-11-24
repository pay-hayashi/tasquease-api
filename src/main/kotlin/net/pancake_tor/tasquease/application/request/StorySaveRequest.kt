package net.pancake_tor.tasquease.application.request

import lombok.Value

@Value
class StorySaveRequest(
    val id: Int?,
    val title: String,
    val description: String,
    val tags: Set<String>,
    val modifiedBy: Int,
)

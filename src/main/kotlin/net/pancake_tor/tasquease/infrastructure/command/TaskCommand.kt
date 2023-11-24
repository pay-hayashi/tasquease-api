package net.pancake_tor.tasquease.infrastructure.command

import lombok.Value

@Value
class TaskCommand(
    val id: Int,
    val storyId: Int,
    val title: String,
    val description: String,
    val tags: String,
    val modifiedBy: Int,
)

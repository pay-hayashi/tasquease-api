package net.pancake_tor.tasquease.infrastructure.command

import lombok.Value

@Value
class StoryCommand(
    val id: Int,
    val title: String,
    val description: String,
    val tags: String,
    val modifiedBy: Int,
)

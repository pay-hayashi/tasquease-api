package net.pancake_tor.tasquease.infrastructure.resource

import lombok.Value
import java.time.LocalDateTime

@Value
class StoryResource(
    val id: Int,
    val title: String,
    val description: String,
    val tags: String,
    val createdAt: LocalDateTime,
    val createdBy: Int,
    val updatedAt: LocalDateTime,
    val updatedBy: Int,
)

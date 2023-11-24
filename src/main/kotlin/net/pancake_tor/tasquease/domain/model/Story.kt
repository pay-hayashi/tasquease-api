package net.pancake_tor.tasquease.domain.model

import lombok.Value
import java.time.LocalDateTime

@Value
class Story(
    val id: Int,
    val title: String,
    val description: String,
    val tags: Set<String>,
    val createdAt: LocalDateTime,
    val createdBy: Int,
    val updatedAt: LocalDateTime,
    val updatedBy: Int,
)

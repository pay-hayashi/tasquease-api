package net.pancake_tor.tasquease.domain.model

import lombok.Value
import java.time.LocalDateTime

@Value
class StoryWithMetadata constructor(
    override val id: Int,
    override val title: String,
    override val description: String,
    override val tags: Set<String>,
    val createdAt: LocalDateTime,
    val createdBy: Int,
    val updatedAt: LocalDateTime,
    val updatedBy: Int,
) : Story(
    id,
    title,
    description,
    tags,
)

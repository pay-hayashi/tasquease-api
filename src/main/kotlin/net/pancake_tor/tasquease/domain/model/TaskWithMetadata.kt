package net.pancake_tor.tasquease.domain.model

class TaskWithMetadata(
    override val id: Int,
    override val storyId: Int,
    override val title: String,
    override val description: String,
    override val tags: Set<String>,
    val createdAt: String,
    val createdBy: String,
    val updatedAt: String,
    val updatedBy: String,
) : Task(
    id,
    storyId,
    title,
    description,
    tags,
)

package net.pancake_tor.tasquease.infrastructure.resource

class TaskResource(
    val id: Int,
    val storyId: Int,
    val title: String,
    val description: String,
    val tags: String,
    val createdAt: String,
    val createdBy: String,
    val updatedAt: String,
    val updatedBy: String,
)

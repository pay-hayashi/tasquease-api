package net.pancake_tor.tasquease.domain.model

import lombok.Value

@Value
class Task(
    val id: Int,
    val storyId: Int,
    val title: String,
    val description: String,
    val tags: List<String>,
    val createdAt: String,
    val createdBy: String,
    val updatedAt: String,
    val updatedBy: String,
)

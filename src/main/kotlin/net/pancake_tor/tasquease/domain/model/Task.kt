package net.pancake_tor.tasquease.domain.model

import lombok.Value

@Value
open class Task(
    open val id: Int,
    open val storyId: Int,
    open val title: String,
    open val description: String,
    open val tags: Set<String>,
)

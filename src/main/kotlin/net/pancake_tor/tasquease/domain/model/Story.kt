package net.pancake_tor.tasquease.domain.model

import lombok.Value

@Value
open class Story(
    open val id: Int,
    open val title: String,
    open val description: String,
    open val tags: Set<String>,
)

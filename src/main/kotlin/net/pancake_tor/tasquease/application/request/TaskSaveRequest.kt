package net.pancake_tor.tasquease.application.request

class TaskSaveRequest(
    val id: Int?,
    val storyId: Int,
    val title: String,
    val description: String,
    val tags: Set<String>,
    val modifiedBy: Int,
)

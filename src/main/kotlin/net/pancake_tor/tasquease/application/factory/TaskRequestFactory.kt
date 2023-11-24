package net.pancake_tor.tasquease.application.factory

import net.pancake_tor.tasquease.application.request.TaskSaveRequest
import net.pancake_tor.tasquease.domain.model.Task
import org.springframework.stereotype.Component

@Component
class TaskRequestFactory {
    fun createTask(taskSaveRequest: TaskSaveRequest): Task {
        return Task(
            id = taskSaveRequest.id ?: -1,
            storyId = taskSaveRequest.storyId,
            title = taskSaveRequest.title,
            description = taskSaveRequest.description,
            tags = taskSaveRequest.tags,
        )
    }
}

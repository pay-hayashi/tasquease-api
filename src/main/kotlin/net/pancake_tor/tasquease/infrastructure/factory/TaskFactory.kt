package net.pancake_tor.tasquease.infrastructure.factory

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.infrastructure.resource.TaskResource
import org.springframework.stereotype.Component

@Component
class TaskFactory {
    fun createTask(taskResource: TaskResource): Task {
        return Task(
            id = taskResource.id,
            storyId = taskResource.storyId,
            title = taskResource.title,
            description = taskResource.description,
            tags = taskResource.tags.split(","),
            createdAt = taskResource.createdAt,
            createdBy = taskResource.createdBy,
            updatedAt = taskResource.updatedAt,
            updatedBy = taskResource.updatedBy
        )
    }
}

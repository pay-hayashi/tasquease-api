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

    fun createTask(taskResources: List<TaskResource>): List<Task> {
        return taskResources.map(this::createTask)
    }

    fun createTaskResource(task: Task): TaskResource {
        return TaskResource(
            id = task.id,
            storyId = task.storyId,
            title = task.title,
            description = task.description,
            tags = task.tags.joinToString(","),
            createdAt = task.createdAt,
            createdBy = task.createdBy,
            updatedAt = task.updatedAt,
            updatedBy = task.updatedBy
        )
    }
}

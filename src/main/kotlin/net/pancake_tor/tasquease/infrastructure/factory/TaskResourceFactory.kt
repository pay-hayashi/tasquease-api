package net.pancake_tor.tasquease.infrastructure.factory

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.model.TaskWithMetadata
import net.pancake_tor.tasquease.infrastructure.command.TaskCommand
import net.pancake_tor.tasquease.infrastructure.resource.TaskResource
import org.springframework.stereotype.Component

@Component
class TaskResourceFactory {
    fun createTask(taskResource: TaskResource): TaskWithMetadata {
        return TaskWithMetadata(
            id = taskResource.id,
            storyId = taskResource.storyId,
            title = taskResource.title,
            description = taskResource.description,
            tags = taskResource.tags.split(",").toHashSet(),
            createdAt = taskResource.createdAt,
            createdBy = taskResource.createdBy,
            updatedAt = taskResource.updatedAt,
            updatedBy = taskResource.updatedBy
        )
    }

    fun createTask(taskResources: List<TaskResource>): List<TaskWithMetadata> {
        return taskResources.map(this::createTask)
    }

    fun createTaskCommand(task: Task, modifiedBy: Int): TaskCommand {
        return TaskCommand(
            id = task.id,
            storyId = task.storyId,
            title = task.title,
            description = task.description,
            tags = task.tags.joinToString(","),
            modifiedBy,
        )
    }
}

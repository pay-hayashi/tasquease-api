package net.pancake_tor.tasquease.infrastructure.repository

import net.pancake_tor.tasquease.domain.exception.NotFoundTaskException
import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.model.TaskWithMetadata
import net.pancake_tor.tasquease.domain.repository.TaskRepository
import net.pancake_tor.tasquease.infrastructure.factory.TaskResourceFactory
import net.pancake_tor.tasquease.infrastructure.mapper.TaskMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TaskRepositoryImpl @Autowired constructor(
    private val taskMapper: TaskMapper,
    private val taskResourceFactory: TaskResourceFactory
) : TaskRepository {

    override fun getTask(taskId: Int): TaskWithMetadata {
        return taskResourceFactory.createTask(taskMapper.findOne(taskId) ?: throw NotFoundTaskException())
    }

    override fun getTasksInStory(storyId: Int): List<TaskWithMetadata> {
        return taskResourceFactory.createTask(taskMapper.findByStoryId(storyId))
    }

    override fun saveTask(task: Task, modifiedBy: Int): TaskWithMetadata {
        val taskCommand = taskResourceFactory.createTaskCommand(task, modifiedBy)
        if (taskMapper.findOne(task.id) == null) {
            taskMapper.insert(taskCommand)
        } else {
            taskMapper.update(taskCommand)
        }
        return taskResourceFactory.createTask(taskMapper.findOne(taskCommand.id) ?: throw NotFoundTaskException())
    }

    override fun deleteTask(taskId: Int) {
        taskMapper.findOne(taskId) ?: throw NotFoundTaskException()
        taskMapper.delete(taskId)
    }


}

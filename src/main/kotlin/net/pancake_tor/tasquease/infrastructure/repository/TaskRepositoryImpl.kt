package net.pancake_tor.tasquease.infrastructure.repository

import net.pancake_tor.tasquease.domain.exception.NotFoundTaskException
import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.repository.TaskRepository
import net.pancake_tor.tasquease.infrastructure.factory.TaskFactory
import net.pancake_tor.tasquease.infrastructure.mapper.TaskMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class TaskRepositoryImpl @Autowired constructor(
    private val taskMapper: TaskMapper,
    private val taskFactory: TaskFactory
) : TaskRepository {

    override fun getTask(taskId: Int): Task {
        return taskFactory.createTask(taskMapper.findOne(taskId) ?: throw NotFoundTaskException())
    }

    override fun getTasksInStory(storyId: Int): List<Task> {
        return taskFactory.createTask(taskMapper.findByStoryId(storyId))
    }

    override fun saveTask(task: Task): Task {
        val taskResource = taskFactory.createTaskResource(task)
        return if (taskMapper.findOne(task.id) == null) {
            taskMapper.insert(taskResource)
            task
        } else {
            taskMapper.update(taskResource)
            task
        }
    }

    override fun deleteTask(taskId: Int) {
        taskMapper.findOne(taskId) ?: throw NotFoundTaskException()
        taskMapper.delete(taskId)
    }


}

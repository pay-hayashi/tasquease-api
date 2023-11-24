package net.pancake_tor.tasquease.domain.service

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.repository.TaskRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class TaskService @Autowired constructor(
    private val taskRepository: TaskRepository
) {
    fun getTask(taskId: Int): Task {
        return taskRepository.getTask(taskId)
    }

    fun getTasksInStory(storyId: Int): List<Task> {
        return taskRepository.getTasksInStory(storyId)
    }

    fun saveTask(task: Task): Task {
        return taskRepository.saveTask(task)
    }

    fun deleteTask(taskId: Int) {
        taskRepository.deleteTask(taskId)
    }
}

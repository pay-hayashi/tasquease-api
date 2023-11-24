package net.pancake_tor.tasquease.application.usecase

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TaskUsecase @Autowired constructor(
    private val taskService: TaskService
) {
    fun getTask(taskId: Int): Task {
        return taskService.getTask(taskId)
    }

    fun saveTask(task: Task): Task {
        return taskService.saveTask(task)
    }

    fun deleteTask(taskId: Int) {
        taskService.deleteTask(taskId)
    }
}

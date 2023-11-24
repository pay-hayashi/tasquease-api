package net.pancake_tor.tasquease.application.usecase

import net.pancake_tor.tasquease.application.factory.TaskRequestFactory
import net.pancake_tor.tasquease.application.request.TaskSaveRequest
import net.pancake_tor.tasquease.domain.model.TaskWithMetadata
import net.pancake_tor.tasquease.domain.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class TaskUsecase @Autowired constructor(
    private val taskRequestFactory: TaskRequestFactory,
    private val taskService: TaskService
) {
    fun getTask(taskId: Int): TaskWithMetadata {
        return taskService.getTask(taskId)
    }

    fun saveTask(taskSaveRequest: TaskSaveRequest): TaskWithMetadata {
        val task = taskRequestFactory.createTask(taskSaveRequest)
        return taskService.saveTask(task, taskSaveRequest.modifiedBy)
    }

    fun deleteTask(taskId: Int) {
        taskService.deleteTask(taskId)
    }
}

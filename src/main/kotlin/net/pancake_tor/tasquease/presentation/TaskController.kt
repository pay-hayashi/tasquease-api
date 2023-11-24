package net.pancake_tor.tasquease.presentation

import net.pancake_tor.tasquease.application.request.TaskSaveRequest
import net.pancake_tor.tasquease.application.usecase.TaskUsecase
import net.pancake_tor.tasquease.domain.model.TaskWithMetadata
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/task")
@RestController
class TaskController @Autowired constructor(
    private val taskUsecase: TaskUsecase,
) {
    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: Int): TaskWithMetadata {
        return taskUsecase.getTask(taskId)
    }

    @PostMapping("")
    fun saveTask(@RequestBody taskSaveRequest: TaskSaveRequest): TaskWithMetadata {
        return taskUsecase.saveTask(taskSaveRequest)
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId: Int) {
        taskUsecase.deleteTask(taskId)
    }
}

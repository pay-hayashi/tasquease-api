package net.pancake_tor.tasquease.presentation

import net.pancake_tor.tasquease.application.usecase.TaskUsecase
import net.pancake_tor.tasquease.domain.model.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/task")
@RestController
class TaskController @Autowired constructor(
    private val taskUsecase: TaskUsecase,
) {
    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: Int) {
        taskUsecase.getTask(taskId)
    }

    @PostMapping("")
    fun saveTask(task: Task) {
        taskUsecase.saveTask(task)
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId: Int) {
        taskUsecase.deleteTask(taskId)
    }
}

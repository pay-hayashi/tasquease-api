package net.pancake_tor.tasquease.presentation

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/task")
@RestController
class TaskController @Autowired constructor(
    private val taskService: TaskService
) {
    @GetMapping("/{taskId}")
    fun getTask(@PathVariable taskId: Int) {
        taskService.getTask(taskId)
    }

    @PostMapping("")
    fun saveTask(task: Task) {
        taskService.saveTask(task)
    }

    @DeleteMapping("/{taskId}")
    fun deleteTask(@PathVariable taskId: Int) {
        taskService.deleteTask(taskId)
    }
}

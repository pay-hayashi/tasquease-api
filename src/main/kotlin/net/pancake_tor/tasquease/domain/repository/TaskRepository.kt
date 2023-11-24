package net.pancake_tor.tasquease.domain.repository

import net.pancake_tor.tasquease.domain.model.Task
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository {
    fun getTask(taskId: Int): Task
    fun getTasksInStory(storyId: Int): List<Task>
    fun saveTask(task: Task): Task
    fun deleteTask(taskId: Int)
}

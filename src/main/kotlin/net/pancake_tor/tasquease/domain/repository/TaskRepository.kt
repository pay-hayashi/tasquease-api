package net.pancake_tor.tasquease.domain.repository

import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.model.TaskWithMetadata
import org.springframework.stereotype.Repository

@Repository
interface TaskRepository {
    fun getTask(taskId: Int): TaskWithMetadata
    fun getTasksInStory(storyId: Int): List<TaskWithMetadata>
    fun saveTask(task: Task, modifiedBy: Int): TaskWithMetadata
    fun deleteTask(taskId: Int)
}

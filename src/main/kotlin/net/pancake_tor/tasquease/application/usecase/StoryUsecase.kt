package net.pancake_tor.tasquease.application.usecase

import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.service.StoryService
import net.pancake_tor.tasquease.domain.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class StoryUsecase @Autowired constructor(
    private val storyService: StoryService,
    private val taskService: TaskService,
) {
    fun getAllStory(): List<Story> {
        return storyService.getStories()
    }

    fun getStory(storyId: Int): Story {
        return storyService.getStory(storyId)
    }

    fun saveStory(story: Story): Story {
        return storyService.saveStory(story)
    }

    fun deleteStory(storyId: Int) {
        storyService.deleteStory(storyId)
    }

    fun getTasksInStory(storyId: Int): List<Task> {
        storyService.getStory(storyId)
        return taskService.getTasksInStory(storyId)
    }
}

package net.pancake_tor.tasquease.application.usecase

import net.pancake_tor.tasquease.application.factory.StoryRequestFactory
import net.pancake_tor.tasquease.application.request.StorySaveRequest
import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.model.StoryWithMetadata
import net.pancake_tor.tasquease.domain.model.Task
import net.pancake_tor.tasquease.domain.service.StoryService
import net.pancake_tor.tasquease.domain.service.TaskService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class StoryUsecase @Autowired constructor(
    private val storyRequestFactory: StoryRequestFactory,
    private val storyService: StoryService,
    private val taskService: TaskService,
) {
    fun getAllStory(): List<Story> {
        return storyService.getStories()
    }

    fun getStory(storyId: Int): Story {
        return storyService.getStory(storyId)
    }

    fun saveStory(storySaveRequest: StorySaveRequest): StoryWithMetadata {
        val story = storyRequestFactory.createStory(storySaveRequest)
        return storyService.saveStory(story, storySaveRequest.modifiedBy)
    }

    fun deleteStory(storyId: Int) {
        storyService.deleteStory(storyId)
    }

    fun getTasksInStory(storyId: Int): List<Task> {
        storyService.getStory(storyId)
        return taskService.getTasksInStory(storyId)
    }
}

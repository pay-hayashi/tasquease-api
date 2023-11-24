package net.pancake_tor.tasquease.domain.service

import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.repository.StoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class StoryService @Autowired constructor(
    private val storyRepository: StoryRepository
) {
    fun getStory(storyId: Int): Story {
        return storyRepository.getStory(storyId)
    }

    fun getStories(): List<Story> {
        return storyRepository.getStories()
    }

    fun saveStory(story: Story): Story {
        return storyRepository.saveStory(story)
    }

    fun deleteStory(storyId: Int) {
        storyRepository.deleteStory(storyId)
    }
}

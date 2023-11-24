package net.pancake_tor.tasquease.domain.repository

import net.pancake_tor.tasquease.domain.model.Story
import org.springframework.stereotype.Repository

@Repository
interface StoryRepository {
    fun getStory(storyId: Int): Story
    fun getStories(): List<Story>
    fun saveStory(story: Story): Story
    fun deleteStory(storyId: Int)
}

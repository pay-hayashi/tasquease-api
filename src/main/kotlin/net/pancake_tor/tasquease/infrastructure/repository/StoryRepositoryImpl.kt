package net.pancake_tor.tasquease.infrastructure.repository

import net.pancake_tor.tasquease.domain.exception.NotFoundStoryException
import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.repository.StoryRepository
import net.pancake_tor.tasquease.infrastructure.factory.StoryFactory
import net.pancake_tor.tasquease.infrastructure.mapper.StoryMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class StoryRepositoryImpl @Autowired constructor(
    private val storyMapper: StoryMapper,
    private val storyFactory: StoryFactory
) : StoryRepository {

    override fun getStory(storyId: Int): Story {
        return storyFactory.createStory(storyMapper.findOne(storyId) ?: throw NotFoundStoryException())
    }

    override fun getStories(): List<Story> {
        return storyFactory.createStory(storyMapper.findAll())
    }

    override fun saveStory(story: Story): Story {
        val storyResource = storyFactory.createStoryResource(story)
        return if (storyMapper.findOne(story.id) == null) {
            storyMapper.insert(storyResource)
            story
        } else {
            storyMapper.update(storyResource)
            story
        }
    }

    override fun deleteStory(storyId: Int) {
        storyMapper.findOne(storyId) ?: throw NotFoundStoryException()
        storyMapper.delete(storyId)
    }
}

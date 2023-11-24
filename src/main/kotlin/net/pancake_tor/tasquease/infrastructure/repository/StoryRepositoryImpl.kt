package net.pancake_tor.tasquease.infrastructure.repository

import net.pancake_tor.tasquease.domain.exception.NotFoundStoryException
import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.model.StoryWithMetadata
import net.pancake_tor.tasquease.domain.repository.StoryRepository
import net.pancake_tor.tasquease.infrastructure.factory.StoryResourceFactory
import net.pancake_tor.tasquease.infrastructure.mapper.StoryMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Repository

@Repository
class StoryRepositoryImpl @Autowired constructor(
    private val storyMapper: StoryMapper,
    private val storyResourceFactory: StoryResourceFactory
) : StoryRepository {

    override fun getStory(storyId: Int): StoryWithMetadata {
        return storyResourceFactory.createStory(storyMapper.findOne(storyId) ?: throw NotFoundStoryException())
    }

    override fun getStories(): List<StoryWithMetadata> {
        return storyResourceFactory.createStory(storyMapper.findAll())
    }

    override fun saveStory(story: Story, modifiedBy: Int): StoryWithMetadata {
        val storyCommand = storyResourceFactory.createStoryCommand(story, modifiedBy)
        if (storyMapper.findOne(story.id) == null) {
            storyMapper.insert(storyCommand)
        } else {
            storyMapper.update(storyCommand)
        }
        return storyResourceFactory.createStory(storyMapper.findOne(storyCommand.id) ?: throw NotFoundStoryException())
    }

    override fun deleteStory(storyId: Int) {
        storyMapper.findOne(storyId) ?: throw NotFoundStoryException()
        storyMapper.delete(storyId)
    }
}

package net.pancake_tor.tasquease.infrastructure.factory

import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.infrastructure.resource.StoryResource
import org.springframework.stereotype.Component

@Component
class StoryFactory {
    fun createStory(storyResource: StoryResource): Story {
        return Story(
            id = storyResource.id,
            title = storyResource.title,
            description = storyResource.description,
            tags = storyResource.tags.split(",").toHashSet(),
            createdAt = storyResource.createdAt,
            createdBy = storyResource.createdBy,
            updatedAt = storyResource.updatedAt,
            updatedBy = storyResource.updatedBy,
        )
    }

    fun createStory(storyResources: List<StoryResource>): List<Story> {
        return storyResources.map(this::createStory)
    }

    fun createStoryResource(story: Story): StoryResource {
        return StoryResource(
            id = story.id,
            title = story.title,
            description = story.description,
            tags = story.tags.joinToString(","),
            createdAt = story.createdAt,
            createdBy = story.createdBy,
            updatedAt = story.updatedAt,
            updatedBy = story.updatedBy,
        )
    }

    fun createStoryResource(stories: List<Story>): List<StoryResource> {
        return stories.map(this::createStoryResource)
    }
}

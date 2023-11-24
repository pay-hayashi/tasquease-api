package net.pancake_tor.tasquease.infrastructure.factory

import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.model.StoryWithMetadata
import net.pancake_tor.tasquease.infrastructure.command.StoryCommand
import net.pancake_tor.tasquease.infrastructure.resource.StoryResource
import org.springframework.stereotype.Component

@Component
class StoryResourceFactory {
    fun createStory(storyResource: StoryResource): StoryWithMetadata {
        return StoryWithMetadata(
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

    fun createStory(storyResources: List<StoryResource>): List<StoryWithMetadata> {
        return storyResources.map(this::createStory)
    }

    fun createStoryCommand(story: Story, modifiedBy: Int): StoryCommand {
        return StoryCommand(
            id = story.id,
            title = story.title,
            description = story.description,
            tags = story.tags.joinToString(","),
            modifiedBy,
        )
    }
}

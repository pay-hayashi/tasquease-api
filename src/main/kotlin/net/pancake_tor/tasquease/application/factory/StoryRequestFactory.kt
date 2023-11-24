package net.pancake_tor.tasquease.application.factory

import net.pancake_tor.tasquease.application.request.StorySaveRequest
import net.pancake_tor.tasquease.domain.model.Story
import org.springframework.stereotype.Component

@Component
class StoryRequestFactory {
    fun createStory(storySaveRequest: StorySaveRequest): Story {
        return Story(
            id = storySaveRequest.id ?: -1,
            title = storySaveRequest.title,
            description = storySaveRequest.description,
            tags = storySaveRequest.tags,
        )
    }
}

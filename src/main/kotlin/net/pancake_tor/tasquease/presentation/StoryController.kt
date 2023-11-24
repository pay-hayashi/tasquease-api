package net.pancake_tor.tasquease.presentation

import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.service.StoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/story")
@RestController
class StoryController @Autowired constructor(
    private val storyService: StoryService
) {
    @GetMapping("")
    fun getAllStory(): List<Story> {
        return storyService.getStories()
    }

    @GetMapping("/{storyId}")
    fun getStory(@PathVariable storyId: Int): Story {
        return storyService.getStory(storyId)
    }

    @PostMapping("")
    fun saveStory(story: Story): Story {
        return storyService.saveStory(story)
    }

    @DeleteMapping("/{storyId}")
    fun deleteStory(@PathVariable storyId: Int) {
        storyService.deleteStory(storyId)
    }
}

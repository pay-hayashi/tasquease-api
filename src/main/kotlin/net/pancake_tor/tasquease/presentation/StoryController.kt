package net.pancake_tor.tasquease.presentation

import net.pancake_tor.tasquease.application.request.StorySaveRequest
import net.pancake_tor.tasquease.application.usecase.StoryUsecase
import net.pancake_tor.tasquease.domain.model.Story
import net.pancake_tor.tasquease.domain.model.Task
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RequestMapping("/story")
@RestController
class StoryController @Autowired constructor(
    private val storyUsecase: StoryUsecase
) {
    @GetMapping("")
    fun getAllStory(): List<Story> {
        return storyUsecase.getAllStory()
    }

    @GetMapping("/{storyId}")
    fun getStory(@PathVariable storyId: Int): Story {
        return storyUsecase.getStory(storyId)
    }

    @PostMapping("")
    fun saveStory(@RequestBody storySaveRequest: StorySaveRequest): Story {
        return storyUsecase.saveStory(storySaveRequest)
    }

    @DeleteMapping("/{storyId}")
    fun deleteStory(@PathVariable storyId: Int) {
        storyUsecase.deleteStory(storyId)
    }

    @GetMapping("/{storyId}/tasks")
    fun getTasksInStory(@PathVariable storyId: Int): List<Task> {
        storyUsecase.getStory(storyId)
        return storyUsecase.getTasksInStory(storyId)
    }
}

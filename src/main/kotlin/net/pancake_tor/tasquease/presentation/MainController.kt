package net.pancake_tor.tasquease.presentation

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MainController {
    @GetMapping("/")
    fun index(): String {
        return "hello world."
    }
}

package net.pancake_tor.tasquease.presentation

import org.apache.ibatis.javassist.NotFoundException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatusCode
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler

@RestControllerAdvice
class ExceptionHandler() : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFoundException(e: NotFoundException, request: WebRequest): ResponseEntity<Any>? {
        return super.handleExceptionInternal(
            e,
            ResponseEntity(e.message, HttpStatusCode.valueOf(404)),
            HttpHeaders(),
            HttpStatusCode.valueOf(404),
            request
        )
    }
}

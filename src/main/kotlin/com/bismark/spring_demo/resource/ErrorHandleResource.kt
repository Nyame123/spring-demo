package com.bismark.spring_demo.resource

import com.bismark.spring_demo.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class ErrorHandleResource {

    @ExceptionHandler(IllegalStateException::class)
    fun handleIllegalState(ex: IllegalStateException): ResponseEntity<ErrorResponse>{
        return ResponseEntity.badRequest().body(ErrorResponse(message = ex.localizedMessage))
    }
}
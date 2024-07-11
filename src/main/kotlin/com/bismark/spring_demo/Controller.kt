package com.bismark.spring_demo

import com.bismark.spring_demo.domain.Person
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class Controller {
    @GetMapping("/hi")
    fun hi(): Person {
        return Person(id = 1L, name = "Nyame", lastName = "Bismark")
    }
}
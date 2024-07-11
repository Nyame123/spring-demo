package com.bismark.spring_demo.transformer

import com.bismark.spring_demo.domain.Person
import com.bismark.spring_demo.dto.AddPersonRequest
import org.springframework.stereotype.Component

@Component
class AddPersonRequestTransformer : Transformer<AddPersonRequest, Person> {
    override fun transform(source: AddPersonRequest): Person {
        return Person(name = source.name, lastName = source.lastName)
    }
}
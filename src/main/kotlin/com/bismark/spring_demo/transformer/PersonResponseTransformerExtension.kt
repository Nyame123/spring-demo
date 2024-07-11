package com.bismark.spring_demo.transformer

import com.bismark.spring_demo.domain.Person
import com.bismark.spring_demo.dto.PersonResponse

fun Person?.toPersonResponse(): PersonResponse{
    return PersonResponse(
        id = this?.id ?: 1L,
        fullName = "${this?.lastName}, ${this?.name}"
    )
}
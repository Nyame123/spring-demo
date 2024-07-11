package com.bismark.spring_demo.resource

import com.bismark.spring_demo.dto.AddPersonRequest
import com.bismark.spring_demo.dto.PersonResponse
import com.bismark.spring_demo.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity

interface PersonResource {
    fun findById(id: Long): ResponseEntity<PersonResponse?>
    fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponse>>
    fun save(addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse>
    fun update(updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse>
    fun deleteById(id: Long): ResponseEntity<Unit>
}
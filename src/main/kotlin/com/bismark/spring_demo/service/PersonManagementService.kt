package com.bismark.spring_demo.service

import com.bismark.spring_demo.dto.AddPersonRequest
import com.bismark.spring_demo.dto.PersonResponse
import com.bismark.spring_demo.dto.UpdatePersonRequest
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface PersonManagementService {

    fun findById(id: Long): PersonResponse?
    fun findAll(pageable: Pageable): Page<PersonResponse>
    fun save(addPersonRequest: AddPersonRequest): PersonResponse
    fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse
    fun deleteById(id: Long)
}
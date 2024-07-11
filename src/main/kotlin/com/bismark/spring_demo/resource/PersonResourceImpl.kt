package com.bismark.spring_demo.resource

import com.bismark.spring_demo.dto.AddPersonRequest
import com.bismark.spring_demo.dto.PersonResponse
import com.bismark.spring_demo.dto.UpdatePersonRequest
import com.bismark.spring_demo.resource.PersonResourceImpl.Companion.BASE_PERSON_URL
import com.bismark.spring_demo.service.PersonManagementService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.net.URI

@RestController
@RequestMapping(value = [BASE_PERSON_URL])
class PersonResourceImpl(private val personManagementService: PersonManagementService) : PersonResource {

    @GetMapping("/{id}")
    override fun findById(@PathVariable id: Long): ResponseEntity<PersonResponse?> {
        val personResponse = personManagementService.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(personResponse)
    }

    @GetMapping
    override fun findAll(pageable: Pageable): ResponseEntity<Page<PersonResponse>> {
       return ResponseEntity.ok(personManagementService.findAll(pageable))
    }

    @PostMapping
    override fun save(@RequestBody addPersonRequest: AddPersonRequest): ResponseEntity<PersonResponse> {
        val personResponse = personManagementService.save(addPersonRequest)
        return ResponseEntity.created(URI.create(BASE_PERSON_URL.plus("/${personResponse.id}")))
            .body(personResponse)
    }

    @PutMapping
    override fun update(@RequestBody updatePersonRequest: UpdatePersonRequest): ResponseEntity<PersonResponse> {
       return ResponseEntity.ok(personManagementService.update(updatePersonRequest))
    }

    @DeleteMapping("/{id}")
    override fun deleteById(@PathVariable id: Long): ResponseEntity<Unit> {
       personManagementService.deleteById(id)
        return ResponseEntity.noContent().build()
    }

    companion object{
        const val BASE_PERSON_URL = "api/v1/person"
    }
}
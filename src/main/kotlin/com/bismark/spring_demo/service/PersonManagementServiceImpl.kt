package com.bismark.spring_demo.service

import com.bismark.spring_demo.dao.PersonDao
import com.bismark.spring_demo.domain.Person
import com.bismark.spring_demo.dto.AddPersonRequest
import com.bismark.spring_demo.dto.PersonResponse
import com.bismark.spring_demo.dto.UpdatePersonRequest
import com.bismark.spring_demo.transformer.AddPersonRequestTransformer
import com.bismark.spring_demo.transformer.toPersonResponse
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class PersonManagementServiceImpl(
    private val personDao: PersonDao,
    private val addPersonRequestTransformer: AddPersonRequestTransformer
) : PersonManagementService {
    override fun findById(id: Long): PersonResponse? = findPersonById(id).toPersonResponse()

    override fun findAll(pageable: Pageable): Page<PersonResponse> = personDao.findAll(pageable).map(Person::toPersonResponse )

    override fun save(addPersonRequest: AddPersonRequest): PersonResponse {
        return saveOrUpdate(addPersonRequestTransformer.transform(addPersonRequest))
    }

    override fun update(updatePersonRequest: UpdatePersonRequest): PersonResponse {
        val person = findPersonById(updatePersonRequest.id) ?: throw IllegalStateException("${updatePersonRequest.id} not found")
        return saveOrUpdate(person.copy(name = updatePersonRequest.name, lastName = updatePersonRequest.lastName))
    }

    override fun deleteById(id: Long) {
        personDao.deleteById(id)
    }

    private fun findPersonById(id: Long): Person? = personDao.findByIdOrNull(id)

    private fun saveOrUpdate(person: Person): PersonResponse = personDao.save(person).toPersonResponse()
}
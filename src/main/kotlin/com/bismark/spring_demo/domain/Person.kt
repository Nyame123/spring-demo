package com.bismark.spring_demo.domain

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.SequenceGenerator


@Entity
data class Person(
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = PERSON_SEQUENCE)
    @SequenceGenerator(name = PERSON_SEQUENCE, sequenceName = PERSON_SEQUENCE, allocationSize=1)
    val id: Long = 0,
    val name: String,
    val lastName: String?,
){
    companion object{
        const val PERSON_SEQUENCE = "person_sequence"
    }
}

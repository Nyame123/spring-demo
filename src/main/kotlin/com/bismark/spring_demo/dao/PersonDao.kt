package com.bismark.spring_demo.dao

import com.bismark.spring_demo.domain.Person
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PersonDao : JpaRepository<Person, Long> {
}
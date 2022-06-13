package com.example.simple

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SimpleRepository : CrudRepository<SimpleModel, UUID> {}

package com.workflow.api.data.repository

import com.workflow.api.data.model.ProjectNodeUnit
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProjectNodeUnitRepository : JpaRepository<ProjectNodeUnit, Long> {
    fun findByTitleIgnoreCase(title: String): Optional<ProjectNodeUnit>
}
package com.gayses.api.controller.work

import com.gayses.api.controller.work.payload.CreateWorkRequest
import com.gayses.api.service.project.ProjectService
import com.gayses.api.service.work.WorkService
import com.gayses.api.utils.ControllerHelper
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/project/{projectId}/work")
class WorkController(
    private val projectService: ProjectService,
    private val workService: WorkService
) {
    @Secured
    @PostMapping
    fun createWork(
        @PathVariable("projectId") projectId: Long,
        @RequestBody data: @Valid CreateWorkRequest
    ): ResponseEntity<Nothing> =
        projectService.getProject(projectId, ControllerHelper.account).let { project ->
            val work = workService.createWork(
                project,
                data.order,
                data.type,
                data.workTitle,
                data.productTitle,
                data.unit,
                data.amount,
                data.performer,
                data.expectedPaymentDate,
                data.paymentDate,
                data.expectedDeliveryDate,
                data.deliveryDate,
                data.expectedFinishDate,
                data.finishDate
            )

            ResponseEntity.ok().build()
        }
}
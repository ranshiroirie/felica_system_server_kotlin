package com.ranshiroirie.felica_system_server.app.controller

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.entity.FelicaOperationHistory
import com.ranshiroirie.felica_system_server.domain.service.felica_operation_history.FelicaOperationHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import java.text.SimpleDateFormat
import java.util.*

@RestController
class FelicaOperationHistoryController {

    @Autowired
    lateinit var felicaOperationHistoryService: FelicaOperationHistoryService

    @GetMapping("/felica_operation_history/get/all")
    fun getFelicaOperationHistoryList():List<FelicaOperationHistory>{
        return  felicaOperationHistoryService.getHistoryListAll()
    }

    @GetMapping("/felica_operation_history/get/datetime")
    fun getFelicaOperationHistoryByDateTime(
        @RequestParam ("select_from_datetime", required=true)select_from_datetime: String,
        @RequestParam ("select_to_datetime", required=true)select_to_datetime: String
    ): List<FelicaOperationHistory> {
        return felicaOperationHistoryService
            .getHistoryListByDateTime(cvtStrToDate(select_from_datetime),cvtStrToDate(select_to_datetime))
    }

    @GetMapping("/felica_operation_history/get/from_datetime")
    fun getFelicaOperationHistoryByDateTimeFrom(
        @RequestParam ("select_from_datetime", required=true)select_from_datetime: String
    ): List<FelicaOperationHistory>{
        return  felicaOperationHistoryService
            .getHistoryListByDateTimeFrom(cvtStrToDate(select_from_datetime))
    }

    @GetMapping("/felica_operation_history/get/to_datetime")
    fun getFelicaOperationHistoryByDateTimeTo(
        @RequestParam ("select_to_datetime", required=true)select_to_datetime: String
    ): List<FelicaOperationHistory>{
        return felicaOperationHistoryService
            .getHistoryListByDateTimeTo(cvtStrToDate(select_to_datetime))
    }

    @PostMapping("/felica_operation_history/add")
    fun insertFelicaOperationHistory(
        @RequestParam ("operation_details", required=true)operation_details: String,
        @RequestParam ("operation_device", required=true)operation_device: String,
        @RequestBody felicaDevice: FelicaDevice
    ){
        felicaOperationHistoryService.insertHistory(
            felicaDevice.felica_id,
            felicaDevice.device_name,
            felicaDevice.card_id,
            felicaDevice.card_pmm,
            felicaDevice.card_sys,
            operation_details,
            operation_device
        )
    }

    private fun cvtStrToDate(str_datetime: String) : Date {
        val datetimeFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssX")
        return try {
            datetimeFormat.parse(str_datetime)
        } catch (t: Throwable) {
            null
        } ?: Date(0)
    }
}
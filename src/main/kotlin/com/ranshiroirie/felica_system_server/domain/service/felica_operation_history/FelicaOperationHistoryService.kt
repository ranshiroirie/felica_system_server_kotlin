package com.ranshiroirie.felica_system_server.domain.service.felica_operation_history

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.entity.FelicaOperationHistory
import java.util.*

interface FelicaOperationHistoryService {

    fun getHistoryListAll():List<FelicaOperationHistory>

    fun getHistoryListByDateTime(select_from_datetime: Date, select_to_datetime: Date):List<FelicaOperationHistory>

    fun getHistoryListByDateTimeFrom(select_from_datetime: Date):List<FelicaOperationHistory>

    fun getHistoryListByDateTimeTo(select_to_datetime: Date):List<FelicaOperationHistory>

    fun insertHistory(
        felica_id: Long,
        device_name: String,
        card_id: String,
        card_pmm: String,
        card_sys: String,
        operation_details: String,
        operation_device: String
    )
}
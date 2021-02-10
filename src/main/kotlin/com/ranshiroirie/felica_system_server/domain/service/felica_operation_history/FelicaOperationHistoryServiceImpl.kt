package com.ranshiroirie.felica_system_server.domain.service.felica_operation_history

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.entity.FelicaOperationHistory
import com.ranshiroirie.felica_system_server.domain.repository.FelicaOperationHistoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class FelicaOperationHistoryServiceImpl : FelicaOperationHistoryService {

    @Autowired
    lateinit var felicaOperationHistoryRepository: FelicaOperationHistoryRepository

    override fun getHistoryListAll(): List<FelicaOperationHistory> {
        return felicaOperationHistoryRepository.selectFelicaOperationHistoryList()
    }

    override fun getHistoryListByDateTime(
        select_from_datetime: Date,
        select_to_datetime: Date
    ): List<FelicaOperationHistory> {
        return felicaOperationHistoryRepository.selectFelicaOperationHistoryDateTime(select_from_datetime, select_to_datetime)
    }

    override fun getHistoryListByDateTimeFrom(select_from_datetime: Date): List<FelicaOperationHistory> {
        return felicaOperationHistoryRepository.selectFelicaOperationHistoryDateTimeFrom(select_from_datetime)
    }

    override fun getHistoryListByDateTimeTo(select_to_datetime: Date): List<FelicaOperationHistory> {

        return felicaOperationHistoryRepository.selectFelicaOperationHistoryDateTimeTo(select_to_datetime)
    }

    override fun insertHistory(
        felica_id: Long,
        device_name: String,
        card_id: String,
        card_pmm: String,
        card_sys: String,
        operation_details: String,
        operation_device: String
    ) {
        felicaOperationHistoryRepository.insertFelicaOperationHistory(felica_id,device_name,card_id,card_pmm,card_sys, operation_details, operation_device)
    }
}
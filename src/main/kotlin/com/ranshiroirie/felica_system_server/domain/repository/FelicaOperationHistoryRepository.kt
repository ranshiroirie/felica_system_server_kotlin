package com.ranshiroirie.felica_system_server.domain.repository

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.entity.FelicaOperationHistory
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository
import java.util.*

@Mapper
@Repository
interface FelicaOperationHistoryRepository {

    @Select("SELECT * FROM felica_operation_history;")
    fun selectFelicaOperationHistoryList():List<FelicaOperationHistory>

    @Select("SELECT * FROM felica_operation_history " +
            "WHERE #{select_from_datetime} <= operation_datetime and operation_datetime < (#{select_to_datetime} + INTERVAL 1 DAY);")
    fun selectFelicaOperationHistoryDateTime(
        @Param("select_from_datetime")select_from_datetime: Date,
        @Param("select_to_datetime")select_to_datetime: Date
    ):List<FelicaOperationHistory>

    @Select("SELECT * FROM felica_operation_history WHERE #{select_from_datetime} <= operation_datetime;")
    fun selectFelicaOperationHistoryDateTimeFrom(
        @Param("select_from_datetime")select_from_datetime: Date
    ):List<FelicaOperationHistory>

    @Select("SELECT * FROM felica_operation_history WHERE operation_datetime < (#{select_to_datetime} + INTERVAL 1 DAY);")
    fun selectFelicaOperationHistoryDateTimeTo(
        @Param("select_to_datetime")select_to_datetime: Date
    ):List<FelicaOperationHistory>

    @Insert("INSERT INTO felica_operation_history" +
            "(felica_id,device_name,card_id,card_pmm,card_sys,operation_details,operation_device) " +
            "values (#{felica_id},#{device_name},#{card_id},#{card_pmm},#{card_sys},#{operation_details},#{operation_device});")
    fun insertFelicaOperationHistory(
        @Param("felica_id")felica_id: Long,
        @Param("device_name")device_name: String,
        @Param("card_id")card_id: String,
        @Param("card_pmm")card_pmm: String,
        @Param("card_sys")card_sys: String,
        @Param("operation_details")operation_details: String,
        @Param("operation_device")operation_device: String
    )
}
package com.ranshiroirie.felica_system_server.domain.service.felica_device

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import org.springframework.scheduling.support.SimpleTriggerContext

interface FelicaDeviceService {

    fun getFelicaDeviceList(): List<FelicaDevice>

    fun getFelicaDeviceByCardInfo(
            card_id: String,
            card_pmm: String,
            card_sys: String
    ): FelicaDevice

    fun getFelicaDeviceById(felica_id: Long): FelicaDevice

    fun getInsertFelicaDeviceInfo(
            device_name: String,
            card_id: String,
            card_pmm: String,
            card_sys: String,
            operation_device: String
    ): FelicaDevice

    fun getUpdateFelicaDeviceNameById(
        felica_id: Long,
        device_name: String,
        operation_device: String
    ): FelicaDevice

    fun getDeleteFelicaDeviceById(
        felica_id: Long,
        operation_device: String
    ): FelicaDevice

}
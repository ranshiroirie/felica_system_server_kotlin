package com.ranshiroirie.felica_system_server.domain.service

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice

interface FelicaDeviceService {

    fun getFelicaDeviceList(): List<FelicaDevice>

    fun getFelicaDeviceByCardInfo(
            device_name: String,
            card_id: String,
            card_pmm: String,
            card_sys: String
    ): FelicaDevice

    fun getFelicaDeviceById(felica_id: Int): FelicaDevice

    fun getInsertFelicaDeviceInfo(
            device_name: String,
            card_id: String,
            card_pmm: String,
            card_sys: String
    ): FelicaDevice

    fun getUpdateFelicaDeviceNameById(felica_id: Int, device_name: String): FelicaDevice

    fun getDeleteFelicaDeviceById(felica_id: Int): FelicaDevice

}
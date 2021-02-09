package com.ranshiroirie.felica_system_server.domain.service

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.repository.FelicaDeviceRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FelicaDeviceServiceImpl : FelicaDeviceService {

    @Autowired
    lateinit var felicaDeviceRepository: FelicaDeviceRepository

    override fun getFelicaDeviceList(): List<FelicaDevice> {
        return felicaDeviceRepository.selectFelicaDeviceList()
    }

    override fun getFelicaDeviceByCardInfo(device_name: String, card_id: String, card_pmm: String, card_sys: String): FelicaDevice {
        return felicaDeviceRepository.selectFelicaDeviceByCardInfo(device_name, card_id, card_pmm, card_sys)
    }

    override fun getFelicaDeviceById(felica_id: Int): FelicaDevice {
        return felicaDeviceRepository.selectFelicaDeviceById(felica_id)
    }

    override fun getInsertFelicaDeviceInfo(device_name: String, card_id: String, card_pmm: String, card_sys: String): FelicaDevice {
        felicaDeviceRepository.insertFelicaDeviceInfo(device_name, card_id, card_pmm, card_sys)
        return felicaDeviceRepository.selectFelicaDeviceByCardInfo(device_name, card_id, card_pmm, card_sys)
    }

    override fun getUpdateFelicaDeviceNameById(felica_id: Int, device_name: String): FelicaDevice {
        felicaDeviceRepository.updateFelicaDeviceNameById(felica_id, device_name)
        return felicaDeviceRepository.selectFelicaDeviceById(felica_id)
    }

    override fun getDeleteFelicaDeviceById(felica_id: Int): FelicaDevice {
        felicaDeviceRepository.deleteFelicaDeviceById(felica_id)
        return felicaDeviceRepository.selectFelicaDeviceById(felica_id)
    }

}
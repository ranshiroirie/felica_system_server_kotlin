package com.ranshiroirie.felica_system_server.domain.service.felica_device

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.repository.FelicaDeviceRepository
import com.ranshiroirie.felica_system_server.domain.service.felica_operation_history.FelicaOperationHistoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class FelicaDeviceServiceImpl : FelicaDeviceService {

    @Autowired
    lateinit var felicaDeviceRepository: FelicaDeviceRepository

    @Autowired
    lateinit var felicaOperationHistoryService: FelicaOperationHistoryService


    override fun getFelicaDeviceList(): List<FelicaDevice> {
        return felicaDeviceRepository.selectFelicaDeviceList()
    }

    override fun getFelicaDeviceByCardInfo(card_id: String, card_pmm: String, card_sys: String): FelicaDevice {
        return felicaDeviceRepository.selectFelicaDeviceByCardInfo(card_id, card_pmm, card_sys)
    }

    override fun getFelicaDeviceById(felica_id: Long): FelicaDevice {
        return felicaDeviceRepository.selectFelicaDeviceById(felica_id)
    }

    override fun getInsertFelicaDeviceInfo(device_name: String, card_id: String, card_pmm: String, card_sys: String): FelicaDevice {
        felicaDeviceRepository.insertFelicaDeviceInfo(device_name, card_id, card_pmm, card_sys)
        val felicaDevice = felicaDeviceRepository.selectFelicaDeviceByCardInfo(card_id, card_pmm, card_sys)
        insertTimestamp(felicaDevice,"Add Device","TEST")
        return felicaDevice
    }

    override fun getUpdateFelicaDeviceNameById(felica_id: Long, device_name: String): FelicaDevice {
        felicaDeviceRepository.updateFelicaDeviceNameById(felica_id, device_name)
        val felicaDevice = felicaDeviceRepository.selectFelicaDeviceById(felica_id)
        insertTimestamp(felicaDevice, "Update Device", "TEST")
        return felicaDevice
    }

    override fun getDeleteFelicaDeviceById(felica_id: Long): FelicaDevice {
        insertTimestamp(felicaDeviceRepository.selectFelicaDeviceById(felica_id),"Delete Device", "TEST")
        felicaDeviceRepository.deleteFelicaDeviceById(felica_id)
        return felicaDeviceRepository.selectFelicaDeviceById(felica_id)
    }

    private fun insertTimestamp(felicaDevice: FelicaDevice, operation_details: String, operation_device: String){
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

}
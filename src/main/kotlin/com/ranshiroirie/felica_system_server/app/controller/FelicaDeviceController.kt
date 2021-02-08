package com.ranshiroirie.felica_system_server.app.controller

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.repository.FelicaDeviceRepository
import com.ranshiroirie.felica_system_server.domain.service.FelicaDeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class FelicaDeviceController {

    @Autowired
    lateinit var felicaDeviceService: FelicaDeviceService

    @GetMapping("/felica_device_all")
    fun getFelicaDeviceList(): List<FelicaDevice>{
        return felicaDeviceService.getFelicaDeviceList()
    }

    @GetMapping("/felica_device/device_name={device_name}+card_id={card_id}+card_pmm={card_pmm}+card_sys={card_sys}")
    fun getFelicaDeviceByCardInfo(
            @PathVariable("device_name")device_name: String,
            @PathVariable("card_id")card_id: String,
            @PathVariable("card_pmm")card_pmm: String,
            @PathVariable("card_sys")card_sys: String
    ): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceByCardInfo(device_name, card_id, card_pmm, card_sys)
    }

    @GetMapping("/felica_device/felica_id={felica_id}")
    fun getFelicaDeviceById(@PathVariable("felica_id")felica_id: Int): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceById(felica_id)
    }

    @PostMapping("/felica_device/device_name={device_name}+card_id={card_id}+card_pmm={card_pmm}+card_sys={card_sys}")
    fun createFelicaDeviceInfo(
            @PathVariable("device_name")device_name: String,
            @PathVariable("card_id")card_id: String,
            @PathVariable("card_pmm")card_pmm: String,
            @PathVariable("card_sys")card_sys: String
    ):FelicaDevice{
        return felicaDeviceService.getInsertFelicaDeviceInfo(device_name, card_id, card_pmm, card_sys)
    }

    @PutMapping("/felica_device/felica_id={felica_id}+device_name={device_name}")
    fun updateFelicaDeviceNameById(
            @PathVariable("felica_id")felica_id: Int,
            @PathVariable("device_name")device_name: String
    ):FelicaDevice{
        return felicaDeviceService.getUpdateFelicaDeviceNameById(felica_id, device_name)
    }

    @DeleteMapping("/felica_device/felica_id={felica_id}")
    fun deleteFelicaDeviceById(@PathVariable("felica_id")felica_id: Int):FelicaDevice{
        return felicaDeviceService.getDeleteFelicaDeviceById(felica_id)
    }
}
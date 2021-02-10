package com.ranshiroirie.felica_system_server.app.controller

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.service.felica_device.FelicaDeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*


@RestController
class FelicaDeviceController {

    @Autowired
    lateinit var felicaDeviceService: FelicaDeviceService

    @GetMapping("/felica_device/get/all")
    fun getFelicaDeviceList(): List<FelicaDevice>{
        return felicaDeviceService.getFelicaDeviceList()
    }

    @GetMapping("/felica_device/get/card_info")
    fun getFelicaDeviceByCardInfo(
        @RequestParam ("device_name", required=true)device_name: String,
        @RequestParam ("card_id", required=true)card_id: String,
        @RequestParam ("card_pmm", required=true)card_pmm: String,
        @RequestParam ("card_sys", required=true) card_sys: String
    ): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceByCardInfo(device_name, card_id, card_pmm, card_sys)
    }

    @GetMapping("/felica_device/get/felica_id")
    fun getFelicaDeviceById(
        @RequestParam ("felica_id",required=true)felica_id: Long
    ): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceById(felica_id)
    }

    @PostMapping("/felica_device/add")
    fun createFelicaDeviceInfo(
        @RequestParam ("device_name", required=true)device_name: String,
        @RequestParam ("card_id", required=true)card_id: String,
        @RequestParam ("card_pmm", required=true)card_pmm: String,
        @RequestParam ("card_sys", required=true)card_sys: String
    ):FelicaDevice{
        return felicaDeviceService.getInsertFelicaDeviceInfo(device_name, card_id, card_pmm, card_sys)
    }

    @PutMapping("/felica_device/update/felica_id")
    fun updateFelicaDeviceNameById(
        @RequestParam ("felica_id",required=true)felica_id: Long,
        @RequestParam ("device_name", required=true)device_name: String
    ):FelicaDevice{
        return felicaDeviceService.getUpdateFelicaDeviceNameById(felica_id, device_name)
    }

    @DeleteMapping("/felica_device/delete/felica_id")
    fun deleteFelicaDeviceById(
        @RequestParam ("felica_id",required=true)felica_id: Long
    ):FelicaDevice{
        return felicaDeviceService.getDeleteFelicaDeviceById(felica_id)
    }
}
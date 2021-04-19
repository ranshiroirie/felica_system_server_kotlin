package com.ranshiroirie.felica_system_server.app.controller

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import com.ranshiroirie.felica_system_server.domain.service.felica_device.FelicaDeviceService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/felica_device")
class FelicaDeviceController {

    @Autowired
    lateinit var felicaDeviceService: FelicaDeviceService

    @GetMapping("/get/all")
    fun getFelicaDeviceList(): ResponseEntity<List<FelicaDevice>>{
        return ResponseEntity.ok(felicaDeviceService.getFelicaDeviceList())
    }

    @GetMapping("/get/card_info")
    fun getFelicaDeviceByCardInfo(
        @RequestParam ("card_id", required=true)card_id: String,
        @RequestParam ("card_pmm", required=true)card_pmm: String,
        @RequestParam ("card_sys", required=true) card_sys: String
    ): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceByCardInfo(card_id, card_pmm, card_sys)
    }

    @GetMapping("/get/felica_id")
    fun getFelicaDeviceById(
        @RequestParam ("felica_id",required=true)felica_id: Long
    ): FelicaDevice{
        return felicaDeviceService.getFelicaDeviceById(felica_id)
    }

    @PostMapping("/add")
    fun createFelicaDeviceInfo(
        @RequestParam ("device_name", required=true)device_name: String,
        @RequestParam ("card_id", required=true)card_id: String,
        @RequestParam ("card_pmm", required=true)card_pmm: String,
        @RequestParam ("card_sys", required=true)card_sys: String,
        @RequestParam ("operation_device", required=true)operation_device: String
    ):ResponseEntity<FelicaDevice>{
        return ResponseEntity.ok(felicaDeviceService.getInsertFelicaDeviceInfo(device_name, card_id, card_pmm, card_sys, operation_device))
    }

    @ExceptionHandler(java.sql.SQLIntegrityConstraintViolationException::class)
    fun exceptionInsertCardInfoExisted(e: java.sql.SQLIntegrityConstraintViolationException) : Map<String, String?> =
        mapOf(Pair("error", e.toString()), Pair("message", "Card Info inserted has been existed. 入力されたカード情報は既に存在しています。"))

    @PutMapping("/update/device_name")
    fun updateFelicaDeviceNameById(
        @RequestParam ("felica_id",required=true)felica_id: Long,
        @RequestParam ("device_name", required=true)device_name: String,
        @RequestParam ("operation_device", required=true)operation_device: String
    ):FelicaDevice{
        return felicaDeviceService.getUpdateFelicaDeviceNameById(felica_id, device_name, operation_device)
    }

    @DeleteMapping("/delete/felica_id")
    fun deleteFelicaDeviceById(
        @RequestParam ("felica_id",required=true)felica_id: Long,
        @RequestParam ("operation_device", required=true)operation_device: String
    ):FelicaDevice{
        return felicaDeviceService.getDeleteFelicaDeviceById(felica_id, operation_device)
    }
}
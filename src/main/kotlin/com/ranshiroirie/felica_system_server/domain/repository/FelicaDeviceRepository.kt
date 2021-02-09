package com.ranshiroirie.felica_system_server.domain.repository

import com.ranshiroirie.felica_system_server.domain.entity.FelicaDevice
import org.apache.ibatis.annotations.*
import org.springframework.stereotype.Repository

@Mapper
@Repository
interface FelicaDeviceRepository {

    @Select("SELECT * FROM felica_device;")
    fun selectFelicaDeviceList(): List<FelicaDevice>

    @Select("SELECT * FROM felica_device WHERE " +
            "device_name = #{device_name} && " +
            "card_id = #{card_id} && " +
            "card_pmm = #{card_pmm} && " +
            "card_sys = #{card_sys};")
    fun selectFelicaDeviceByCardInfo(
            @Param("device_name")device_name: String,
            @Param("card_id")card_id: String,
            @Param("card_pmm")card_pmm: String,
            @Param("card_sys")card_sys: String
    ): FelicaDevice

    @Select("SELECT * FROM felica_device WHERE felica_id = #{felica_id};")
    fun selectFelicaDeviceById(@Param("felica_id")felica_id: Int): FelicaDevice

    @Insert("INSERT INTO felica_device(felica_id, device_name, card_id, card_pmm, card_sys) " +
            "select max(felica_id) + 1, #{device_name}, #{card_id}, #{card_pmm}, #{card_sys} from felica_device;")
    fun insertFelicaDeviceInfo(
            @Param("device_name")device_name: String,
            @Param("card_id")card_id: String,
            @Param("card_pmm")card_pmm: String,
            @Param("card_sys")card_sys: String
    )

    @Update("UPDATE felica_device SET device_name = #{device_name} where felica_id = #{felica_id};")
    fun updateFelicaDeviceNameById(
            @Param("felica_id")felica_id: Int,
            @Param("device_name")device_name: String
    )

    @Delete("DELETE FROM felica_device WHERE felica_id = #{felica_id};")
    fun deleteFelicaDeviceById(@Param("felica_id")felica_id: Int) : Int

}
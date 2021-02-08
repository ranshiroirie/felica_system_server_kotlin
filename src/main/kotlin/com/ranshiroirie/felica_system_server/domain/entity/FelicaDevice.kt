package com.ranshiroirie.felica_system_server.domain.entity

import java.sql.Timestamp

data class FelicaDevice (
        var felica_id: Long,
        var device_name: String,
        var card_id: String,
        var card_pmm: String,
        var card_sys: String,
        var registered_datetime:Timestamp
        )
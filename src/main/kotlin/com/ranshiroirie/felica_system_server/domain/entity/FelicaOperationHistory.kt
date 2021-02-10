package com.ranshiroirie.felica_system_server.domain.entity

import java.util.*

data class FelicaOperationHistory (
    var operation_datetime : Date,
    var felica_id : Int,
    var device_name: String,
    var card_id: String,
    var card_pmm: String,
    var card_sys: String,
    var operation_details : String,
    var operation_device : String
)
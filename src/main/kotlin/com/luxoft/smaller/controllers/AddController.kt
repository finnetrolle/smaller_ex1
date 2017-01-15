package com.luxoft.smaller.controllers

import com.luxoft.smaller.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
class AddController {

    @Autowired lateinit var service: KeyMapperService

    @PostMapping("add")
    fun addLink(@RequestBody request: AddRequest) = AddResponse(request.link, service.add(request.link))

    data class AddRequest(val link: String)
    data class AddResponse(val link: String, val key: String)

}
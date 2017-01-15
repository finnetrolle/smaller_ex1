package com.luxoft.smaller.controllers

import com.luxoft.smaller.exception.KeyNotFoundException
import com.luxoft.smaller.service.KeyMapperService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import org.springframework.web.servlet.ModelAndView

@Controller
class ThymeController {

    @Value("\${app.address}")
    private lateinit var address: String

    @Autowired lateinit private var service: KeyMapperService

    @RequestMapping(path = arrayOf("addhtml"), method = arrayOf(RequestMethod.POST))
    fun addHtml(model: Model, @RequestParam(value = "link", required = true) link: String) : String {
        val key = service.add(link);
        model.addAttribute("link", link)
        model.addAttribute("keyed", "$address$key")
        return "result"
    }

    @RequestMapping("/")
    fun home() = "home"

    @RequestMapping("/{key}")
    fun redirect(@PathVariable("key") key: String) = ModelAndView("redirect:${service.get(key)}")

    @ExceptionHandler(KeyNotFoundException::class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "There are no such key")
    fun runtime(){}

}
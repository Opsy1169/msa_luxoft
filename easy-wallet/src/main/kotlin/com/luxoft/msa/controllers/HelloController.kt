package com.luxoft.msa.controllers

import UserService
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody


@Controller
class HelloController {

    @GetMapping("/hello")
    @ResponseBody
    fun hello(): String {
        val service = UserService()
        return "Hello, " + service.getName()
    }
}
package personal.MapleChenX.service.controller

import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
class KtTestController {


    @RequestMapping("test")
    fun test(): String {
        return "Hello, World!"
    }


}
package personal.MapleChenX.service.controller

import cn.dev33.satoken.SaManager.log
import cn.dev33.satoken.stp.StpUtil
import cn.dev33.satoken.util.SaResult
import lombok.extern.slf4j.Slf4j
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@Slf4j
class UserController {

    @RequestMapping("/login")
    fun doLogin(username: String, password: String): SaResult {
        log.info("login")
        StpUtil.login(10001)
        log.info("username: $username, password: $password")
        return SaResult.ok("login success")
    }

    @RequestMapping("/isLogin")
    fun isLogin(): String{
        return "isLogin? ${StpUtil.isLogin()}"
    }

    @RequestMapping("/logout")
    fun logout(): SaResult {
        StpUtil.logout()
        return SaResult.ok("logout success")
    }

    @RequestMapping("/tokenInfo")
    fun tokenInfo(): SaResult {
        return SaResult.data(StpUtil.getTokenInfo())
    }

    fun test(){
        val session = StpUtil.getSession()
        log.info("test")
    }

}
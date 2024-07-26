package personal.MapleChenX.im_service.controller;

import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.MapleChenX.im_service.service.UserImService;

@RestController
public class UserImController  {

    @Resource
    private UserImService userImService;

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 用户信息查询接口
     */
    @RequestMapping("/getUserInfo")
    public String getUserInfo() {
        return userImService.getUserInfo();
    }

    /**
     * 用户删除
     */
    @RequestMapping("/deleteUser")
    public String deleteUser() {
        return "deleteUser";
    }



}

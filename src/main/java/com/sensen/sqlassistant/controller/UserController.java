package com.sensen.sqlassistant.controller;

import com.alibaba.fastjson.JSONObject;
import com.sensen.sqlassistant.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;


    @ResponseBody
    @RequestMapping("/vue-admin-template/user/login")
    public String login(@RequestParam("username") String username,@RequestParam("password") String password){
        System.out.println(username);
        System.out.println(password);
        if (StringUtils.isBlank(username)) {
           throw  new RuntimeException();
        }
        userService.login(username);
        JSONObject ret  = new JSONObject();
        ret.put("code", 200);
        JSONObject data = new JSONObject();
        data.put("token", "admin-token");
        ret.put("data", data);
        return JSONObject.toJSONString(ret);

    }

    @ResponseBody
    @RequestMapping("/vue-admin-template/user/info")
    public String info(@RequestParam("token") String token){
        System.out.println(token);
        JSONObject ret  = new JSONObject();
        ret.put("code", 200);
        JSONObject data = new JSONObject();
        data.put("token", "admin-token");
        data.put("avatar", "https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
        ret.put("data", data);
        return JSONObject.toJSONString(ret);

    }

    @ResponseBody
    @RequestMapping("/vue-admin-template/user/logout")
    public String logout(){

        JSONObject ret  = new JSONObject();
        ret.put("code", 200);
        JSONObject data = new JSONObject();
        data.put("token", "admin-token");
        ret.put("data", data);
        return JSONObject.toJSONString(ret);

    }

    //后台登陆



}

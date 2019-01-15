package com.natsuki.ego.sso.controller;

import com.natsuki.ego.beans.EgoResult;
import com.natsuki.ego.rpc.pojo.TbUser;
import com.natsuki.ego.sso.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: xuzhiwei
 * @Date: 2019-01-15
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/check/{param}/{type}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MappingJacksonValue userCheck(@PathVariable String param, @PathVariable Integer type, @RequestParam(required = false) String callback) {

        EgoResult user = userService.getUserByCond(param, type);
        return getMappingJacksonValue(callback, user);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EgoResult userRegister(TbUser user) {
        return userService.saveUser(user);
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public EgoResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        return userService.selectUser(username, password,request,response);
    }

    @RequestMapping(value = "/token/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MappingJacksonValue userToken(@PathVariable String token, @RequestParam(required = false) String callback) {
        EgoResult user = userService.getUserByToken(token);
        return getMappingJacksonValue(callback, user);
    }

    @RequestMapping(value = "/logout/{token}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public MappingJacksonValue userLogout(@PathVariable String token, @RequestParam(required = false) String callback) {
        EgoResult user = userService.deleteUserByToken(token);
        return getMappingJacksonValue(callback, user);
    }

    private MappingJacksonValue getMappingJacksonValue(@RequestParam(required = false) String callback, EgoResult user) {
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(user);
        if (StringUtils.isEmpty(callback)) {
            return mappingJacksonValue;
        }
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }


}

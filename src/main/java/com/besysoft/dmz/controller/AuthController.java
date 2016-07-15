package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.User;
import com.fasterxml.jackson.core.JsonParser;
import com.oracle.webservices.internal.api.message.ContentType;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * Created by lzielinski on 14/07/2016.
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE, headers = "content-type=*")
    //public String login(@RequestBody User user) {
    public String login (@RequestBody User user) {
        System.out.println("AuthController, post login");
        System.out.println(user.getName());
        System.out.println(user.getPass());



        return "success";
    }

}

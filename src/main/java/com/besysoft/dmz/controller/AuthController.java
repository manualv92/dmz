package com.besysoft.dmz.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by lzielinski on 14/07/2016.
 */

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public String login(@RequestBody ModelTest requestBody) {
        System.out.println("AuthController, post login");
        System.out.println(requestBody);

        return "success";
    }

    public class ModelTest {
        String username;
        String password;

        @Override
        public String toString() {
            return this.username + ' ' + this.password;
        }
    }

}

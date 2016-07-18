package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.User;
import com.besysoft.dmz.security.Token;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by lzielinski on 14/07/2016.
 */

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/auth")
public class AuthController {

    private String uri = "http://localhost:8091/api/auth";
    HttpHeaders headers = new HttpHeaders();
    RestTemplate rt = new RestTemplate();

    public AuthController() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes=MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/json")
    public ResponseEntity login (@RequestBody User user) {
        HttpEntity<String> entity = new HttpEntity<>(user.toJsonString() , headers);

        try {
            String resStatus = rt.exchange(uri, HttpMethod.POST, entity, String.class).getStatusCode().toString();
            if (!("200").equals(resStatus)) return new ResponseEntity<>("{\"sucess\": \"false\"}", headers, HttpStatus.FORBIDDEN);

            return new ResponseEntity<>("{\"sucess\": \"true\", \"access-token\": \"" + user.getUserToken() + "\"}", headers, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>("{\"sucess\": \"false\"}", headers, HttpStatus.FORBIDDEN);
    }

}

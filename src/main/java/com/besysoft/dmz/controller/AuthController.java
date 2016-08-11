package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.User;
import com.besysoft.dmz.security.Token;
import com.besysoft.dmz.utils.JsonParser;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
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

    public AuthController() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/json"
    )
    public ResponseEntity login (@RequestBody User user) {

        HttpEntity<String> entity = new HttpEntity<>(JsonParser.toJsonString(user) , headers);
        RestTemplate rt = new RestTemplate();

        HttpStatus responseStatus = HttpStatus.SERVICE_UNAVAILABLE;
        try {
            ResponseEntity<String> resPapiBridge = rt.exchange(uri, HttpMethod.POST, entity, String.class);
            if (!("200").equals(resPapiBridge.getStatusCode().toString())) return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.FORBIDDEN);

            return new ResponseEntity<>("{\"success\": \"true\", \"token\": \"" + Token.getJwt(user) + "\"}", headers, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            responseStatus = HttpStatus.FORBIDDEN;
            System.out.println(e.getMessage());
        } catch (HttpServerErrorException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>("{\"sucess\": \"false\"}", responseStatus);
    }

}

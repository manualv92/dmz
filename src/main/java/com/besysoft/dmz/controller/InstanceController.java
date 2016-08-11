package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.Process;
import com.besysoft.dmz.entity.User;
import com.besysoft.dmz.security.Token;
import com.besysoft.dmz.utils.JsonParser;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

/**
 * Created by manua on 30/6/2016.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class InstanceController {

    private String uri = "http://localhost:8091/api/instance";
    HttpHeaders headers = new HttpHeaders();

    public InstanceController() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @RequestMapping(
            value = "/instance",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/json"
    )
    public ResponseEntity getInstances(@RequestHeader String authorization) {
        if (authorization.length() == 0) return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.FORBIDDEN);
        User user = new Token(authorization).getUser();
        headers.set("username", user.getUsername());
        headers.set("password", user.getPassword());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate rt = new RestTemplate();

        try {
            ResponseEntity<String> resPapiBridge = rt.exchange(uri, HttpMethod.GET, entity, String.class);

            if (!("200").equals(resPapiBridge.getStatusCode().toString())) return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.FORBIDDEN);

            return new ResponseEntity<>(resPapiBridge.getBody(), headers, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(
            value = "/instance/{id}",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/json"
    )
    public ResponseEntity getInstanceInfo(
            @RequestHeader String authorization,
            @PathVariable("id") String id) {
        if (authorization.length() == 0) return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.FORBIDDEN);

        User user = new Token(authorization).getUser();
        headers.set("username", user.getUsername());
        headers.set("password", user.getPassword());

        HttpEntity<String> entity = new HttpEntity<>(headers);
        RestTemplate rt = new RestTemplate();

        ResponseEntity<String> resPapiBridge = null;
        try {
            resPapiBridge = rt.exchange(uri + '/' + id, HttpMethod.GET, entity, String.class);

            if (!("200").equals(resPapiBridge.getStatusCode().toString())) return new ResponseEntity<>("{\"sucess\": \"false\"}", HttpStatus.FORBIDDEN);

            return new ResponseEntity<>(resPapiBridge.getBody(), headers, HttpStatus.OK);
        } catch (HttpClientErrorException e) {
            System.out.println(e.getMessage());
        }

        return new ResponseEntity<>(resPapiBridge.getBody(), HttpStatus.OK);
    }

}
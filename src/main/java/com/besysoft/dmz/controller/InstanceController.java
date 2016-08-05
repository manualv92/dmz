package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.Process;
import com.besysoft.dmz.entity.User;
import com.besysoft.dmz.security.Token;
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

    private String uri = "http://localhost:8091/api/instances";
    HttpHeaders headers = new HttpHeaders();

    public InstanceController() {
        headers.setContentType(MediaType.APPLICATION_JSON);
    }

    @RequestMapping(
            value = "/instances",
            method = RequestMethod.GET,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            headers = "content-type=application/json"
    )
    public ResponseEntity instance(@RequestHeader String authorization) {
        String user = new Token(authorization).getUser();

        HttpEntity<String> entity = new HttpEntity<>(user, headers);

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

}
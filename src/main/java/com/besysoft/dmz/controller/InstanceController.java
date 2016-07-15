package com.besysoft.dmz.controller;

import com.besysoft.dmz.entity.Process;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by manua on 30/6/2016.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class InstanceController {

    @CrossOrigin(origins = "*")
    @RequestMapping("/instances")
    public Process instance() {
        System.out.println("8090/instances");
        RestTemplate rt = new RestTemplate();

        Process i = rt.getForObject("http://localhost:8091/processes", Process.class);

        System.out.println("Intancia ameo" + i);

/*
        List<Bank> banks = new ArrayList<>();
        banks.add(new Bank("BSJ", 12345));
        banks.add(new Bank("BSC", 20000));
        banks.add(new Bank("BERSA", 30000));
        banks.add(new Bank("NBSF", 40000));

        return new Instance(instanceNro,desc,total,banks);*/
        return i;
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value = "/login")
    public String login() { //@RequestParam(value="username") String username, @RequestParam(value="password") String password
        System.out.println("AuthController, post login");
        // System.out.println("Username: " + username);
        //System.out.println("password: " + password);

        return "success";
    }
}

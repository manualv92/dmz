package business;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by manua on 30/6/2016.
 */
@RestController
public class InstanceController {
    @CrossOrigin(origins = "*")
    @RequestMapping("/instances")
    public Instance instance(@RequestParam(value="description", defaultValue = "Solicitudes de BPM") String desc,
                             @RequestParam(value="total", defaultValue = "99999") long total,
                             @RequestParam(value="nro", defaultValue = "444") long instanceNro) {
        System.out.println("8090/instances");
        RestTemplate rt = new RestTemplate();

        Instance i = rt.getForObject("http://localhost:8091/instances", Instance.class);

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
}

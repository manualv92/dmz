package business;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
                             @RequestParam(value="nro", defaultValue = "444") long instanceNro,
                             @RequestParam(value="banks", defaultValue = "BSC") String banks) {
        System.out.println("/instances");
        return new Instance(instanceNro,desc,total,banks);
    }
}

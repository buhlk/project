package pl.buhl.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.buhl.api.model.Insurance;
import pl.buhl.api.service.InsuranceService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class InsuranceController {

    @Autowired
    InsuranceService insuranceService;

    @GetMapping("/insurance")
    public List<Insurance> get() {
        return insuranceService.getAll();
    }

    @PostMapping("/insurance")
    public void post(@RequestBody String body)
    {
        insuranceService.insert(body);
    }

    @DeleteMapping("/insurance")
    public void delete()
    {
        insuranceService.deleteAll();
    }
}
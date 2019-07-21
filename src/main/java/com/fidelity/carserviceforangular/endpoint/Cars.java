package com.fidelity.carserviceforangular.endpoint;

import com.fidelity.carserviceforangular.Repository.CarRepository;
import com.fidelity.carserviceforangular.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class Cars {
    private final CarRepository repo;

    public Cars(CarRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Car> getCars(@RequestParam(defaultValue = "") String filter, @RequestParam(required = false) Integer count) {
        int limit = count != null ? count : 0;
        return repo.getCars(filter, limit);
    }
}

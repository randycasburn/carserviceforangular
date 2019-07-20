package com.fidelity.carserviceforangular.endpoint;

import com.fidelity.carserviceforangular.Repository.CarRepository;
import com.fidelity.carserviceforangular.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/cars")
public class Cars {
    @Autowired
    CarRepository repo;

    @GetMapping
    public List<Car> getCars(@RequestParam(defaultValue = "") String filter, @RequestParam(required = false) Integer count ) {
        int limit = count != null? count : 0;
        return repo.getCars(filter, limit);
    }
}

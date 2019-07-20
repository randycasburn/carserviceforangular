package com.fidelity.carserviceforangular.Repository;

import com.fidelity.carserviceforangular.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CarRepository {
    @Autowired
    Car car;

    private List<Car> cars;

    CarRepository(Car car) {
        cars = new ArrayList<>();
        cars.add(new Car("Roadster", "Tesla", 2017, 2, 120_000.0));
        cars.add(new Car("F40", "Ferrari", 2017, 2, 500_000.0));
        cars.add(new Car("Smart C453", "Daimler AG", 2016, 3, 16_000.0));
        cars.add(new Car("Pacifica Hybrid", "Chrysler", 2018, 5, 40_000.0));
        cars.add(new Car("Model 3", "Tesla", 2016, 4, 46_000.0));
        cars.add(new Car("Palisade", "Hyundai", 2020, 5, 54_000.0));
    }

    public List<Car> getCars(String filter, int count) {
        Comparator comparator;
        int limit = (count != 0)? count : cars.size();
        switch(filter){
            case("model") :
                comparator = Comparator.comparing(Car::getModel);
                break;
            case("make") :
                comparator = Comparator.comparing(Car::getMake);
                break;
            case("year"):
                comparator = Comparator.comparingInt(Car::getYear);
                break;
            case("doors"):
                comparator = Comparator.comparingInt(Car::getDoors);
                break;
            default:
                comparator = Comparator.comparingDouble(Car::getPrice);
        }

        return getCarsFiltered(comparator, limit);
    }

    public List<Car> getCarsFiltered(Comparator<? super Car> comparator, int limit) {
        return (List<Car>) cars.stream()
                .sorted(comparator)
                .limit(limit)
                .collect(Collectors.toList());
    }

}

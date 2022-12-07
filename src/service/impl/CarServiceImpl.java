package service.impl;

import classes.Car;
import classes.Person;
import service.CarService;

import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    private List<Car> cars = new ArrayList<>();

    @Override
    public String createCar(List<Car> cars) {
        this.cars.addAll(cars);
        return "Successfully create!";
    }

    @Override
    public String removeCar(String name, List<Car> cars) {
        boolean isRemoved = this.cars.removeIf(car -> car.getName().equals(name));
        return isRemoved ? "Successfully removed!" : "Removed failed!";
    }

    @Override
    public List<Car> getAll(List<Car>cars) {
        return cars;
    }

    @Override
    public List<Car> findByName(String name, List<Car> cars) {
        List<Car> carList = new ArrayList<>();
            for (Car car: cars) {
                if (car.getName().equals(name)) {
                    carList.add(car);
                }
            }
        return carList;
    }

    @Override
    public List<Car> findByCountry(String name, List<Car> cars) {
        List<Car> carList = new ArrayList<>();
        for (Car car:cars) {
            if(car.getCountryOfOrigin().name().equals(name)){
                carList.add(car);
            }
        }
        return carList;
    }
}

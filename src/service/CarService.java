package service;

import classes.Car;
import classes.Person;

import java.util.List;

public interface CarService {
    String createCar(List<Car>cars);

    String removeCar(String name,List<Car>cars);

    List<Car>getAll(List<Car> cars);

    List<Car>findByName(String name, List<Car>cars);

    List<Car> findByCountry(String name, List<Car> cars);

}

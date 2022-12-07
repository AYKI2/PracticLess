package service;

import classes.Car;
import classes.Person;

import java.util.List;

public interface PersonService{
    String createPerson(List<Person> people);

    String removePerson(String name, List<Person> people);

    List<Person> getAll();

    List<Person> findByName(String name, List<Person> people);

    List<Person> findByCarName(String name, List<Person> people);

    String payCars(String name, List<Person> people, String carName, List<Car> cars);

    List<Person>sortPersonDateOfBirth(List<Person>people);

    List<Person>sortPersonName(List<Person>people);

    List<Person>sortGender(List<Person>people);

    int getAge(String name, List<Person> people);
}

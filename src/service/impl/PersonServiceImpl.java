package service.impl;

import classes.Person;
import classes.Car;
import enums.Gender;
import service.PersonService;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;

public class PersonServiceImpl implements PersonService {
    private List<Person> people = new ArrayList<>();

    @Override
    public String createPerson(List<Person> people) {
        this.people.addAll(people);
        return "Successfully created!";
    }

    @Override
    public String removePerson(String name, List<Person> people) {
        boolean isRemoved = this.people.removeIf(person -> person.getName().equals(name));
        return isRemoved ? "Successfully removed!" : "Removed failed!";
    }

    @Override
    public List<Person> getAll() {
        return this.people;
    }

    @Override
    public List<Person> findByName(String name, List<Person> people) {
        List<Person> personList = new ArrayList<>();
        for (Person person : this.people) {
            if (person.getName().equals(name)) {
                personList.add(person);
            }
        }
        return personList;
    }

    @Override
    public List<Person> findByCarName(String name, List<Person> people) {
        List<Person> personList = new ArrayList<>();
        for (Person person : people) {
            for (Car car : person.getCars()) {
                if (car.getName().equals(name)) {
                    personList.add(person);
                }
            }
        }
        return personList;
    }

    @Override
    public String payCars(String name, List<Person> people, String carName, List<Car> cars) {
        List<Car> carList = new ArrayList<>();
        for (Person person : people) {
            for (Car car : cars) {
                if (person.getName().equals(name)) {
                    if (car.getName().equals(carName)) {
                        boolean b = person.getMoney().intValue() > car.getPrice().intValue();
                        if (b) {
                            carList.addAll(person.getCars());
                            carList.add(car);
                            person.setCars(carList);
                            person.setMoney(person.getMoney().subtract(car.getPrice()));
                            cars.remove(car);
                            return "Successfully payed!";
                        } else {
                            return "Not enough money!";
                        }
                    }
                }
            }
        }
        return null;
    }

    @Override
    public List<Person> sortPersonDateOfBirth(List<Person> people) {
        List<Person> personList = new ArrayList<>();
        personList.addAll(people);
        personList.sort(personComparator);
        return personList;
    }

    @Override
    public List<Person> sortPersonName(List<Person> people) {
        List<Person> personList = new ArrayList<>();
        personList.addAll(people);
        personList.sort(personComparator1);
        return personList;
    }

    @Override
    public List<Person> sortGender(List<Person> people) {
        List<Person> personList = new ArrayList<>();
        personList.addAll(people);
        personList.sort(personComparator2);
        return personList;
    }

    @Override
    public int getAge(String name, List<Person> people) {
        for (Person person : people) {
            if (person.getName().equals(name)) {
                System.out.print(person.getName() + "'s age: ");
                return Period.between(person.getDateOfBirth(), LocalDate.now()).getYears();
            }
        }
        return 0;
    }

    public Comparator<Person> personComparator = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getDateOfBirth().compareTo(o2.getDateOfBirth());
        }
    };
    public Comparator<Person> personComparator1 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public Comparator<Person> personComparator2 = new Comparator<Person>() {
        @Override
        public int compare(Person o1, Person o2) {
            return o2.getGender().compareTo(o1.getGender());
        }
    };
}

import classes.Car;
import classes.Person;
import enums.Colour;
import enums.Country;
import enums.Gender;
import service.impl.CarServiceImpl;
import service.impl.PersonServiceImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Year;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static PersonServiceImpl personService = new PersonServiceImpl();
    public static CarServiceImpl carService = new CarServiceImpl();
    public static void main(String[] args) {
        Car BMW = new Car("BMW","M5",new BigDecimal(120000), Year.of(2015), Colour.BLUE, Country.GERMANY);
        Car Mercedes = new Car("Mercedes","Maybach",new BigDecimal(120000), Year.of(2020), Colour.BLACK, Country.GERMANY);
        Car Subaru = new Car("Subaru","BL5",new BigDecimal(120000), Year.of(2003), Colour.ORANGE, Country.JAPAN);
        Car Rolls_Royce = new Car("Rolls_Royce","Phantom",new BigDecimal(120000), Year.of(2006), Colour.WHITE, Country.ENGLAND);
        List<Car> cars = new ArrayList<>(List.of(BMW,Mercedes,Subaru,Rolls_Royce));

        Person person1 = new Person("Iskhak", LocalDate.of(2002, 8,28), Gender.MALE, new BigDecimal(2000000), "+996507434242",List.of(Rolls_Royce));
        Person person2 = new Person("Yntymak", LocalDate.of(2002, 1,15), Gender.MALE, new BigDecimal(2000000), "+123456789123",List.of());
        Person person3 = new Person("Jenishbek", LocalDate.of(2000, 5,5), Gender.MALE, new BigDecimal(2000000), "+996345678909",List.of());
        Person person4 = new Person("Aijamal", LocalDate.of(1995, 3,17), Gender.FEMALE, new BigDecimal(2000000), "+996876545673",List.of());
        Person person5 = new Person("Jiydegul", LocalDate.of(1997, 11,3), Gender.FEMALE, new BigDecimal(2000000), "+996507434242",List.of());
        Person person6 = new Person("Alibek", LocalDate.of(2002, 5,5), Gender.MALE, new BigDecimal(2000000), "+996345678909",List.of());
        List<Person>people = new ArrayList<>(List.of(person1,person2,person3,person4,person5,person6));
        commands(people,cars);

    }

    public static void commands(List<Person> people, List<Car>cars) {
        boolean isTrue = true;
        while (true) {
            System.out.println("""
                    Choice: 
                    Person(1),
                    Car(2)         
                    """);
            int number = scanner.nextInt();
            if (isTrue){
                if (number == 1) {
                System.out.println("""
                        1 -> Create,
                        2 -> Remove,
                        3 -> ShowAll,
                        4 -> Find by name,
                        5 -> Find by car name,
                        6 -> Pay car,
                        7 -> Sort by date of birth,
                        8 -> Sort by name,
                        9 -> Sort by gender,
                        10 -> Show person age,
                        0 -> Exit;
                        """);
                number = scanner.nextInt();
                    switch (number) {
                        case 1 -> System.out.println(personService.createPerson(people));
                        case 2 -> {
                            System.out.println("Enter person name: ");
                            System.out.println(personService.removePerson(scanner.next(), people));
                        }
                        case 3 -> System.out.println(personService.getAll());
                        case 4 -> {
                            System.out.println("Enter person name: ");
                            System.out.println(personService.findByName(scanner.next(), people));
                        }
                        case 5 -> {
                            System.out.println("Enter car name: ");
                            System.out.println(personService.findByCarName(scanner.next(), people));
                        }
                        case 6 -> {
                            System.out.println("Enter person name: ");
                            String personName = scanner.next();
                            System.out.println("Enter car name: ");
                            String personCar = scanner.next();
                            System.out.println(personService.payCars(personName, people, personCar, cars));
                        }
                        case 7 -> System.out.println(personService.sortPersonDateOfBirth(people));
                        case 8 -> System.out.println(personService.sortPersonName(people));
                        case 9 -> System.out.println(personService.sortGender(people));
                        case 10 -> {
                            System.out.println("Enter person name: ");
                            System.out.println(personService.getAge(scanner.next(), people));
                        }
                        case 0 -> isTrue = false;
                        default -> System.out.println("Incorrect input!");
                    }
                }
            } else {
                System.out.println("""
                        1 -> Create,
                        2 -> Remove,
                        3 -> ShowAll,
                        4 -> Find by name,
                        5 -> Find by country;
                        0 -> Exit
                        """);
                number = scanner.nextInt();
                switch (number) {
                    case 1 -> System.out.println(carService.createCar(cars));
                    case 2 -> {
                        System.out.println("Enter car name: ");
                        System.out.println(carService.removeCar(scanner.next(), cars));
                    }
                    case 3 -> System.out.println(carService.getAll(cars));
                    case 4 -> {
                        System.out.println("Enter person name: ");
                        System.out.println(carService.findByName(scanner.next(), cars));
                    }
                    case 5 -> {
                        System.out.println("Enter country: ");
                        System.out.println(carService.findByCountry(scanner.next(), cars));
                    }
                    case 0 -> isTrue = false;
                    default -> System.out.println("Incorrect input!");
                }
            }
        }
    }
}
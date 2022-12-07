package classes;

import enums.Gender;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Person {
    private String name;
    private LocalDate dateOfBirth;
    private Gender gender;
    private BigDecimal money;
    private String phoneNumber;
    private List<Car> cars;

    public Person() {
    }

    public Person(String name, LocalDate dateOfBirth, Gender gender, BigDecimal money, String phoneNumber, List<Car> cars) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.money = money;
        this.phoneNumber = phoneNumber;
        this.cars = cars;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        return "\nPerson: " +
                "\nname = " + name +
                "\ndateOfBirth = " + dateOfBirth +
                "\ngender = " + gender +
                "\nmoney = " + money +
                "\nphoneNumber = " + phoneNumber +
                "\ncars = " + cars + "\n";
    }
}

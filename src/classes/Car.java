package classes;

import enums.Colour;
import enums.Country;

import java.math.BigDecimal;
import java.time.Year;

public class Car {
    private String name;
    private String mark;
    private BigDecimal price;
    private Year releaseYear;
    private Colour color;
    private Country countryOfOrigin;

    public Car() {
    }

    public Car(String name, String mark, BigDecimal price, Year releaseYear, Colour color, Country countryOfOrigin) {
        this.name = name;
        this.mark = mark;
        this.price = price;
        this.releaseYear = releaseYear;
        this.color = color;
        this.countryOfOrigin = countryOfOrigin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Year getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(Year releaseYear) {
        this.releaseYear = releaseYear;
    }

    public Colour getColor() {
        return color;
    }

    public void setColor(Colour color) {
        this.color = color;
    }

    public Country getCountryOfOrigin() {
        return countryOfOrigin;
    }

    public void setCountryOfOrigin(Country countryOfOrigin) {
        this.countryOfOrigin = countryOfOrigin;
    }

    @Override
    public String toString() {
        return "Car: " +
                "\nname = " + name +
                "\nmark = " + mark +
                "\nprice = " + price +
                "\nreleaseYear = " + releaseYear +
                "\ncolor = " + color +
                "\ncountryOfOrigin = " + countryOfOrigin + "\n";
    }
}

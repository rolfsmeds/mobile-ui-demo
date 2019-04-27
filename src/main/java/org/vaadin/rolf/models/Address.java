package org.vaadin.rolf.models;

public class Address {
    private String street;
    private int number;
    private String postalCode;
    private String city;

    public Address() {

    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return String.format("%s %s", postalCode, city);
    }

    public Address(String street, int number, String postalCode) {
        super();
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
    }

    public Address(String postalCode, String city) {
        super();
        this.postalCode = postalCode;
        this.city = city;
    }


}
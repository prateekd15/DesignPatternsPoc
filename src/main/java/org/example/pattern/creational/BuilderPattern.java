package org.example.pattern.creational;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
class Person {
    private String name;
    private int age;
    private String phoneNo;
    private Address address;

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    //Lombok @Builder annotation does exactly the same thing as this code
    @NoArgsConstructor
    public static class PersonBuilder {
        private String name;
        private int age;
        private String phoneNo;
        private Address address;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }
        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }
        public PersonBuilder phoneNo(String phoneNo) {
            this.phoneNo = phoneNo;
            return this;
        }

        public PersonBuilder address(Address address) {
            this.address = address;
            return this;
        }

        public Person build() {
            return new Person(name, age, phoneNo, address);
        }
    }
}

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
class Address {
    private String apartment;
    private String street;
    private String city;
    private String country;
}

public class BuilderPattern {

    public static void main(String[] args) {
        Address address = new Address("1A", "New Street", "Pune", "India");
        Address builderAddress = Address.builder().apartment("1B").street("New Street").city("Pune").country("India").build();

        Person constructorPerson = new Person("Emma", 33, "123-456-7890", address);
        System.out.println(constructorPerson);

        Person builderPerson = Person.builder().name("Taylor").age(33).address(builderAddress).phoneNo("123-456-7891").build();
        System.out.println(builderPerson);
    }
}

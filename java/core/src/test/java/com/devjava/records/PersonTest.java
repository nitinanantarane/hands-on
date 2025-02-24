package com.devjava.records;

import junit.framework.TestCase;
import org.junit.Assert;

import static org.junit.Assert.assertNotEquals;

public class PersonTest extends TestCase {

    public void testPerson_WhenNameAndAddressGiven() {
        String name = "Nitin";
        String address = "India";
        Person person = new Person(name, address);
        Assert.assertEquals(name, person.name());
        Assert.assertEquals(address, person.address());
    }

    public void testPerson_WhenEqualsAndHashcodeNotOverridden() {
        Person person1 = new Person("Nitin", "India");
        Person person2 = new Person("Nitin", "USA");
        Person person3 = new Person("nitin", "india");
        Person person4 = new Person("Nitin", "India");

        assertNotEquals(person1, person2);
        assertNotEquals(person2, person3);
        assertNotEquals(person1, person3);
        assertEquals(person1, person4);
    }


}
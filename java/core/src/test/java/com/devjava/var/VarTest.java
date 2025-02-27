package com.devjava.var;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VarTest {
    // NOT ALLOWED var in instance variable
    // public var name = "value";

    @Test
    public void whenVarInitWithString_thenGetStringTypeVar() {
        var message = "Hello, Java 10";
        assertTrue(message instanceof  String);
    }

    @Test
    public void whenVarInitWithSubClassDiamondOp_thenGetSubClassObject() {
        var empList = new ArrayList<>();
        assertTrue(empList instanceof List<Object>);
        assertTrue(empList instanceof ArrayList<Object>);
    }

    @Test
    public void whenVarInitWithAnonymous_thenGetAnonymousType() {
        var obj = new Object() {};
        assertNotEquals(Object.class, obj.getClass());

        // not allowed
        // obj = new Object();
    }
}

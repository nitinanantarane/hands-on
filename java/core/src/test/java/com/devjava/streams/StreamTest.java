package com.devjava.streams;

import junit.framework.TestCase;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class StreamTest extends TestCase {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    public void setUp() {
        //System.out.println("Before");
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    public void tearDown() {
        //System.out.println("After");
        System.setOut(standardOut);
    }

    public void test1() {
        String message = "Hello, Good Morning!";
        print(message);
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    public void test2() {
        String message = "Hello, Good Night!";
        print(message);
        assertEquals(message, outputStreamCaptor.toString().trim());
    }

    public void testWhenStreamSorted_thenGetSortedString() {
        List<String> cities = Arrays.asList("Shenzhen", "Brussels", "Taipei", "Buenos Aires", "Sydney", "Bristol");
                cities.stream()
                .filter(s -> s.startsWith("B"))
                .map(String::toUpperCase)
                .sorted()
                .forEach(this::print);

        String expectedOutput = "BRISTOL\r\nBRUSSELS\r\nBUENOS AIRES";

        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    public void testWhenStreamTransformList_thenGetList() {
        Stream<String> stream = Stream.of("Shenzhen", "Brussels", "Taipei", "Buenos Aires", "Sydney", "Bristol");
        List<String> list = stream.sorted().toList();
        System.out.println(list);

        String sortedCities = """
                [Bristol, Brussels, Buenos Aires, Shenzhen, Sydney, Taipei]""";
        assertEquals(sortedCities, outputStreamCaptor.toString().trim());

    }
    
    public void testWhenBlockTransformList_thenGetList() {
        var cities = """
              San Francisco
              Casablanca
              Antwerp
              New Delhi
              Osaka
        """;

        Stream<String> lines = cities.indent(-12).lines();
        List<String> list = lines.toList();
        System.out.println(list);

        String expectedOutput = "[San Francisco, Casablanca, Antwerp, New Delhi, Osaka]";
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    public void testWhenUnnamedConsumer_thenGetLoop() {
        String message = "I'm not interested in this argument";
        List<String> strings = List.of("one", "two", "three");
        Consumer<String> notInterested = _ -> print(message);
        strings.forEach(notInterested);

        String expectedOutput = message + "\r\n" + message + "\r\n" + message;
        assertEquals(expectedOutput, outputStreamCaptor.toString().trim());
    }

    private void print(String message) {
        System.out.println(message);
    }
}

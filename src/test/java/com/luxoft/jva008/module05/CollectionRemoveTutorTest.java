package com.luxoft.jva008.module05;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Test;

interface ShouldRemove<T> {
    boolean check(T elem);
}

public class CollectionRemoveTutorTest {
    String[] animals = { "Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human" };

    public String joinByCycle(Collection<?> c) {
        StringBuilder builder = new StringBuilder();
        for (Object item : c) {
            builder.append(item);
            if (builder.length() > 0) {
                builder.append(", ");
            }
        }
        return builder.toString();
    }

    public List<String> getAnimals() {
        return new ArrayList<>(Arrays.asList(animals));
    }

    // Remove all entrances of word "Cow"
    public void unCow(List<String> list) {
        List<String> toRemove = new ArrayList<>();
        for (String item : list) {
            if ("Cow".equals(item)) {
                toRemove.add(item);
            }
        }
        list.removeAll(toRemove);
    }

    // Remove all entrances having 3 letters
    public void un3Letterization(List<String> list) {
        List<String> toRemove = new ArrayList<>();
        for (String item : list) {
            if (item.length() == 3) {
                toRemove.add(item);
            }
        }
        list.removeAll(toRemove);
    }

    // Implement method removeIf which will take interface ShouldRemove as a parameter
    public <T> List<T> removeIf(List<T> list, ShouldRemove<T> shouldRemove) {
        List<T> toRemove = new ArrayList<>();
        for (T item : list) {
            if (shouldRemove.check(item)) {
                toRemove.add(item);
            }
        }
        list.removeAll(toRemove);
        return list;
    }

    @Test
    public void testRemove() {
        List<String> list;

        list = getAnimals();
        unCow(list);
        log("list after remove: " + joinByCycle(list));

        list = getAnimals();
        un3Letterization(list);
        log("list after remove 3 letters animals: " + joinByCycle(list));
    }

    private void log(String string) {
        System.out.println(string);
    }

    @Test
    public void unCow_emptyList_doNothing() {
        List<String> list = new ArrayList<>();

        unCow(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void unCow_1CowList_removeCowFromList() {
        List<String> list = new ArrayList<>();

        list.add("Cow");

        unCow(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void unCow_2CowAndAnyStringList_removeKorovaFromList() {
        List<String> list = new ArrayList<>();

        list.add("Cow");
        list.add("anystring");
        list.add("Cow");

        unCow(list);

        assertEquals(1, list.size());
        assertEquals("anystring", list.get(0));
    }

    @Test
    public void un3Letterization_emptyList_doNothing() {
        List<String> list = new ArrayList<>();

        un3Letterization(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void un3Letterization_1FourLettersWordList_removeFourLettersWordFromList() {
        List<String> list = new ArrayList<>();

        list.add("333");

        un3Letterization(list);

        assertTrue(list.isEmpty());
    }

    @Test
    public void deFourLetterization_2FourLettersWordsAndAnyStringList_removeFourLettersWordsFromList() {
        List<String> list = new ArrayList<>();

        list.add("333");
        list.add("anystring");
        list.add("333");

        un3Letterization(list);

        assertEquals(1, list.size());
        assertEquals("anystring", list.get(0));
    }

}

package com.luxoft.jva008.module05;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.Iterator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CollectionTutorTest {
    String[] animals = {"Cow", "Goose", "Cat", "Dog", "Elephant", "Rabbit", "Snake", "Chicken", "Horse", "Human", "Cow"};

    /**
     * This method should return the ArrayList with all the animals
     */
    public List<String> getAnimalsList() {
        log(String.join(",", Arrays.asList(animals)));
        return Arrays.asList(animals);
    }

    private void log(String join) {
    }

    /**
     * The method must return a Set with all the animals
     */
    public Set<String> getAnimalsSet() {
        return new LinkedHashSet<>(Arrays.asList(animals));
    }

    /**
     * Method should take a collection of strings and return one string consisting of all collection elements,
     * separated by commas, using for loop
     */
    public String joinByCycle(Collection<?> c) {
        StringBuilder result = new StringBuilder();
        for (Object item : c) {
            if (result.length() > 0) {
                result.append(",");
            }
            result.append(item.toString());
        }
        return result.toString();
    }

    /**
     * Method should take a collection of strings and return one string consisting of all collection elements,
     * separated by commas, using iterator
     */
    public String joinByIterator(Collection<?> c) {
        StringBuilder result = new StringBuilder();
        Iterator<?> iterator = c.iterator();
        while (iterator.hasNext()) {
            Object item = iterator.next();
            result.append(item.toString());
            if (iterator.hasNext()) {
                result.append(",");
            }
        }
        return result.toString();
    }

   @Test
   public void testCollections() {
       log("getAnimalsList: " + joinByCycle(Arrays.asList(animals)));

       log("getAnimalsList: " + joinByCycle(getAnimalsList()));
       log("getAnimalsSet: " + joinByCycle(getAnimalsSet()));

       log("getAnimalsList by iterator: " + joinByIterator(getAnimalsList()));
   }

   @Test
   public void getAnimalsListShouldReturnsListContainsAllAnimals() {
       List<String> list = getAnimalsList();
       assertTrue(list.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void getAnimalsSetShouldReturnsSetContainsAllAnimals() {
       Set<String> set = getAnimalsSet();
       assertTrue(set.containsAll(Arrays.asList(animals)));
   }

   @Test
   public void joinByCycleShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByCycle(make123Collection());
       assertEquals("1,2,3", result);
   }

   @Test
   public void joinByIteratorShouldReturnsStringWithAllAnimalsJoined() {
       String result = joinByIterator(make123Collection());
       assertEquals("1,2,3", result);
   }

   private Collection<String> make123Collection() {
       Collection<String> collection = new LinkedHashSet<String>();
       collection.add("1");
       collection.add("2");
       collection.add("3");
       return collection;
   }
}

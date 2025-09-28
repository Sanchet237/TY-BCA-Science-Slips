/*Q1. Construct a Linked List having names of Fruits: Apple, Banana, Guava and Orange. Display 
the contents of the List using an Iterator. [10 Marks]*/

import java.util.*;

public class LinkedList_Fruits {
    public static void main(String[] args) {

        LinkedList<String> fruits = new LinkedList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Guava");
        fruits.add("Orange");

        Iterator<String> iterator = fruits.iterator();

        System.out.println("Fruits in the list:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
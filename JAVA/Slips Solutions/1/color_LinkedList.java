/*Q2. Construct a linked List containing names of colours: red, blue, yellow and orange. Then 
extend the program to do the following: 
i. Display the contents of the List using an Iterator 
ii. Display the contents of the List in reverse order using a ListIterator 
iii. Create another list containing pink and green. Insert the elements of this list between 
blue and yellow.  */

import java.util.*;

public class color_LinkedList {
    public static void main(String[] args) {

        LinkedList<String> colors = new LinkedList<>();
        colors.add("red");
        colors.add("blue");
        colors.add("yellow");
        colors.add("orange");

        System.out.println("Colors in the list:");
        Iterator<String> it = colors.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }

        System.out.println("\nColors in reverse order:");
        ListIterator<String> revIt = colors.listIterator(colors.size());
        while (revIt.hasPrevious()) {
            System.out.println(revIt.previous());
        }

        LinkedList<String> newColors = new LinkedList<>();
        newColors.add("pink");
        newColors.add("green");

        int pos = colors.indexOf("yellow");
        colors.addAll(pos, newColors);

        System.out.println("\nUpdated Colors in the list:");
        for (String color : colors) {
            System.out.println(color);
        }
    }
}

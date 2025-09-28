/*Q2. Write a program to read the contents of “abc.txt” file. Display the contents of file in 
uppercase as output. [20 Marks]  */ 

import java.io.*; 
public class FileUppercase { 
    public static void main(String[] args) { 
        try (FileReader fr = new FileReader("abc.txt")) { 
            int ch; 
            System.out.println("Contents of file in UPPERCASE:\n"); 
            while ((ch = fr.read()) != -1) { 
                System.out.print(Character.toUpperCase((char) ch)); 
            } 
        } catch (IOException e) { 
            System.out.println("Error reading file: " + e.getMessage()); 
        } 
    } 
}
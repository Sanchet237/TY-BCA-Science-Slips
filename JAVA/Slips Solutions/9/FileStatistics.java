// Q2. Write a program that displays the number of characters, lines and words of a file. [20 Marks] 

import java.io.*;

public class FileStatistics {
    public static void main(String[] args) {
        String fileName = "File.txt"; 
        int lines = 0, words = 0, chars = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                lines++;
                chars += line.length();
                if (!line.trim().isEmpty()) {
                    words += line.trim().split("\\s+").length;
                }
            }

            System.out.println("Lines: " + lines);
            System.out.println("Words: " + words);
            System.out.println("Characters: " + chars);

        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

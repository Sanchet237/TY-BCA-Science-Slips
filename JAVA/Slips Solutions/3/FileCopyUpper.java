/* Q2. Write a program to copy the contents from one file into another file in upper case. */

import java.io.*;

public class FileCopyUpper {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));

            String line;
            
            while ((line = br.readLine()) != null) {
                bw.write(line.toUpperCase());
                bw.newLine();
            }

            br.close();
            bw.close();

            System.out.println("File copied successfully in UPPERCASE.");
        } 
        catch (FileNotFoundException e) {
            System.out.println("Error: Input file not found.");
        } 
        catch (IOException e) {
            System.out.println("Error: Problem while reading/writing file.");
        }
    }
}
 

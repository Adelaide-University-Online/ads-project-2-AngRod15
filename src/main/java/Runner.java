import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
* File: filename.java
* Description: A brief description of this Java module.
* Author: Steve Jobs
* Student ID: 12345678
* Email ID: jobst007
* AI Tool Used: Y/N (This includes all AI Tools e.g. ChatGPT, Microsoft or Github Copiliot etc... Please leave blank if you do not wish to share this information)
* This is my own work as defined by
*    the University's Academic Integrity Policy.
**/
public class Runner {
    
    public static void main(String[] args) {
        Graph  graph = new Graph();

        // try reading the file
        try {
            File file = new File("XBDA.txt");
            Scanner scanner = new Scanner(file);

            // Read the first line of the file - this should be all the courses.
            String firstLine = scanner.nextLine();

            // Split the line by commas to get the individual courses.
            String[] courses = firstLine.split(",");

            // Add each course as a vertex in the graph
            for (String course : courses) {
                graph.addVertex(course.trim());
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Check that the vertices have been created in the graph
        System.out.println(graph.getVertices().toString());
        
    }


    
}

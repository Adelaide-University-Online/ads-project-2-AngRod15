/**
 * File: Vertex.java
 * Description: A class to represent a vertex in a graph.
 * Author: Angie Rodley
 * Student ID: a3145754
 * Email ID: angie.rodley@student.adelaide.edu.au
 * AI Tool Used: Co-pilot in-line suggestions was turned on and Chat-GPT to help with Syntax of Kahn's Algorithm
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Runner {
    
    public static void main(String[] args) {
        Graph  graph = new Graph();

        // initialise a scanner for user input
        Scanner input = new Scanner(System.in);

        // try reading the file
        try {
            //File file = new File("XBDA.txt");
            System.out.println("Please enter file name (e.g. XBDA.txt): ");
            String fileName = input.nextLine();

            File file = new File(fileName);

            Scanner scanner = new Scanner(file);

            // Read the first line of the file - this should be all the courses.
            String firstLine = scanner.nextLine();

            // Split the line by commas to get the individual courses.
            String[] courses = firstLine.split(",");

            // Add each course as a vertex in the graph
            for (String course : courses) {
                graph.addVertex(course.trim());
            }

            // move on to the next lines that contain the course and its prerequisites.
            while (scanner.hasNextLine()) {

                // Scan the next line
                String line = scanner.nextLine();

                // Split it into each course by comma
                // The course is the first one [0]
                String[] parts = line.split(",");
                String course = parts[0].trim();

                // Iterate through the prerequisites - start from 1
                for (int i = 1; i < parts.length; i++) {
                    String prerequisite = parts[i].trim();

                    // Add the edge to the course.
                    graph.addEdge(prerequisite, course);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
        }

        // Check that the vertices have been created in the graph
        //System.out.println(graph.getVertices().toString());

        // Check that the edges have been created
        //System.out.println(graph.getEdges().toString());

        System.out.println("How many courses do you want to study concurrently? ");
        int numCourses = input.nextInt();

        // Perform the topological sort to find the best path for visiting all the vertices.
        List<List<String>> sortedGraph = graph.topoSort(numCourses);


        // Print out the schedule by term
        System.out.println("Your course schedule is:");
        System.out.println("-----------------------------");

        // Counter to keep track of terms
        int term = 1;

        // Loop through the sort and print out the courses for each term.
        for (List<String> t : sortedGraph) {
            System.out.println("\nTerm " + term + ":");

            for (String course : t) {
                System.out.println("  " + course);
            }

            // Increment the term counter
            term++;
        }
    }
}

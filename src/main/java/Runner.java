import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
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

        // initialise a scanner for user input
        Scanner input = new Scanner(System.in);

        // try reading the file
        try {
            //File file = new File("XBDA.txt");
            System.out.println("Please enter file name: ");
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
        System.out.println(graph.getVertices().toString());

        // Check that the edges have been created
        System.out.println(graph.getEdges().toString());

        // Perform the topological sort to find the best path for visiting all the vertices.
        List<String> sortedGraph = graph.topoSort();

        System.out.println("Topologically sorted graph: ");

        for (String course : sortedGraph) {
            System.out.println(course);
        }



        
    }
}

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

import java.util.Objects;

/**
 * This class represents a Vertex in a graph.
 * The vertex is represented by a course code (a string).
 **/
public class Vertex {
    private String courseCode;

    /**
     * Constructor for creating a vertex
     * @param courseCode The code that represents the course.
     *                   This is the unique identifier for the vertex in the graph.
     * **/
    public Vertex(String courseCode) {
        this.courseCode = courseCode;
    }

    // Function to get the course code
    public String getCourseCode() {
        return courseCode;
    }

    // Override of toString to display a string representation of the vertex - the course code.
    @Override
    public String toString() {
        return "Vertex(" + "Course Code = " + courseCode + ')';
    }

    // Override HashCode
    @Override
    public int hashCode() {
        return Objects.hash(courseCode);
    }

    // Override equals
    @Override
    public boolean equals(Object obj) {

        // Return True if the same object
        if (this == obj) {
            return true;
        }

        // Return false if not the same object
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        // Compare courseCodes to determine if equal
        Vertex vertex = (Vertex) obj;
        return Objects.equals(courseCode, vertex.courseCode);
    }
}

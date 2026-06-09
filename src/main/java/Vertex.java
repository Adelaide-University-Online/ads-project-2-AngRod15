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
        return "Vertex{" + "Course Code = " + courseCode + '}';
    }
}

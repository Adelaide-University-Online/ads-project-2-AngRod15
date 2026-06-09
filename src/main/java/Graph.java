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

// Import all the java utilities
import java.util.*;

/**
 * This is a class to represent a graph, the graph contains hashmaps of vertices and edges.
 * **/
public class Graph {

    // String variables for vertices and edges
    private Map<String, Vertex> vertices;
    private Map<String, List<Edge>> edges;

    // constructor
    public Graph() {
        vertices = new HashMap<>();
        edges = new HashMap<>();
    }

    public void addVertex(String courseCode) {
        vertices.put(courseCode, new Vertex(courseCode));
        edges.put(courseCode, new ArrayList<>());
    }

    public void addEdge(String from, String to) {
        edges.get(from).add(new Edge(from, to));
    }

    // A function to print all the "from" for a vertex

    // A function to get the total number of verticies getNumV

    public Map<String, Vertex> getVertices() {
        return vertices;
    }

    public Map<String, List<Edge>> getEdges() {
        return edges;
    }

    // Create a topological search (as per the textbook) to find the best path for visiting all the vertices.
    // topological search will be a depth first search that will visit all the vertices
    // and keep track of the best path.

    // Research Kahn's algorithm - recursive.



}

/**
 * File: Graph.java
 * Description: A class to represent a graph.
 * Author: Angie Rodley
 * Student ID: a3145754
 * Email ID: angie.rodley@student.adelaide.edu.au
 * AI Tool Used: Co-pilot in-line suggestions was turned on and Chat-GPT to help with Syntax of Kahn's Algorithm
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

// Import all the java utilities
import java.util.*;

/**
 * This is a class to represent a graph, the graph contains hashmaps of vertices and edges.
 * The graph created will be directional with a weight of 1 applied to all edges - resulting in an
 * unweighted graph.
 * **/
public class Graph {

    // String variables for vertices and edges
    private Map<String, Vertex> vertices;
    private Map<String, List<Edge>> edges;

    /**
     * Instantiate a new graph with empty HashMaps for vertices and edges.
     * **/
    public Graph() {
        this.vertices = new HashMap<>();
        this.edges = new HashMap<>();
    }

    /**
     * Adds a vertex to the graph.
     * @param courseCode The code of the course to be added.
     * **/
    public void addVertex(String courseCode) {
        this.vertices.put(courseCode, new Vertex(courseCode));
        this.edges.put(courseCode, new ArrayList<>());
    }
    /**
     * Adds an edge to the graph.
     * @param from The course that is the prerequisite.
     * @param to The course that depends on the prerequisite.
     * **/
    public void addEdge(String from, String to) {
        this.edges.get(from).add(new Edge(from, to));

    }

    // Getter for vertices
    public Map<String, Vertex> getVertices() {
        return this.vertices;
    }

    // Getter for edges
    public Map<String, List<Edge>> getEdges() {
        return this.edges;
    }

    // Create a topological search (as per the textbook) to find the best path for visiting all the vertices.
    // topological search will be a depth first search that will visit all the vertices
    // and keep track of the best path.

    // Research Kahn's algorithm - recursive.

    // Method for the topological sort.
    /**
     * Method to sort the graph
     * This is a Topological sort using Kahn's Algorithm
     * @param numCourses The number of courses the student wants to take concurrently,
     *                   this will determine how many courses can be added to the schedule for each term.
     * **/
    public List<List<String>> topoSort(int numCourses) {

        // Use HashMap to store the in-degrees, these change as the graph is being
        // traversed, using hashmap is 0(1) making it efficient for changing the
        // indegrees values as the vertices are processed.
        Map<String, Integer> indegree = new HashMap<>();

        // All courses start with an in-degree of 0, then we will calculate the actual indegrees.
        for (String course : vertices.keySet()) {
            indegree.put(course, 0);
        }

        // Calculate the in-degree (incoming edges) for each vertex by iterating through the edges.
        // The in-degree represents how many prerequisites a course has.

        // For each course
        for (String course : edges.keySet()) {
            // Get the adjacency list that contains edges
            List<Edge> edgeList = edges.get(course);

            // For each edge in the list, get the "to" vertex and increment its in-degree by 1.
            for (Edge edge : edgeList) {
                String to = edge.getTo();

                // Increment the indegree list by one for each prerequisite.
                indegree.put(to, indegree.get(to) + 1);
            }
        }

        // Use a queue to store the courses with no prerequisites
        // this will get filled as the traversal progresses
        // A linkedList is used here as it provides queue like behaviour (FIFO)
        Queue<String> queue = new LinkedList<>();

        // Add courses with no prerequisites to the queue (in-degree of 0)

        // for each course in the indegree list, if value is 0, add to the queue.
        for (String course : indegree.keySet()) {
            if (indegree.get(course) == 0) {
                queue.add(course);
            }
        }

        // Initialise an ArrayList to store the final result or the search.
        List<List<String>> result = new ArrayList<>();

        // Counter to keep track of how many courses have been processed
        int courseCounter = 0;



        // Kahn's Algorithm Topological Sort.
        // While the queue is not empty
        while (!queue.isEmpty()) {

            // Accommodate for the number of subjects per term
            List<String> currentTerm =  new ArrayList<>();

            // Store the number of courses that can be added for the term
            // This will be smaller of the number set by user or the size of courses ready in the queue
            int termSize = Math.min(numCourses, queue.size());

            for (int i = 0; i < termSize; i++) {
                // Set the current vertex to the first in the queue and add it to the result list.
                String current = queue.remove();
                currentTerm.add(current);

                // Add to the courseCounter
                courseCounter++;

                // Visit all courses that depend on the current course.
                for  (Edge edge : edges.get(current)) {
                    String to = edge.getTo();

                    // Reduce the indegree of the dependent course by 1, as we have now processed one of its prerequisites.
                    indegree.put(to, indegree.get(to) - 1);

                    // If the indegree is now 0, that dependent course can be added to the queue.
                    if (indegree.get(to) == 0) {
                        queue.add(to);
                    }
                }
            }

            // Add processed course to the current term
            result.add(currentTerm);
        }

        // Ensure all verticies have been processed, for a topological sort, there must not
        // be any cycles. The graph must be a Directed Acyclic Graph (DAG).
        // Check if the size of the result list is the same size as the vertices.
        if (courseCounter != vertices.size()) {
            throw new RuntimeException("Graph has a cycle, topological sort not possible.");
        }

    // Return the result of the sort.
    return result;
    }

    // Geeks for geeks, October 2025, Topological sorting using BRS - Kahn's Algorithm,
    // https://www.geeksforgeeks.org/dsa/topological-sorting-indegree-based-solution/

    // Koffman, EB 2016, Data structures : abstraction and design using Java /
    // Elliot B Koffman; Paul A. T. Wolfgang., Third edition., John Wiley & Sons, Incorporated



    // Override toString
    public String toString() {
        return "Graph\n" +
                "Vertices: " + vertices + " \n" +
                "Edges=" + edges;
    }

    // Override hashCode
    @Override
    public int hashCode() {
        return Objects.hash(vertices, edges);
    }

    /**
     * Method to override equals. Two graphs are the same if they have the same vertices and edges.
     * **/
    @Override
    public boolean equals(Object graph) {
        if (this == graph) {
            return true;
        }
        if (graph == null || getClass() != graph.getClass()) {
            return false;
        }
        Graph graph2 = (Graph) graph;

        // Compare the HashMaps for vertices and edges to see if they are the same.
        return Objects.equals(vertices, graph2.vertices) && Objects.equals(edges, graph2.edges);
    }
}

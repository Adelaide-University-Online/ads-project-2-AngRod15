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
import java.security.MessageDigest;
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

    // Method for the topological sort.
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

            // For each edge in the list, get the "to" vertex and increment its indegree by 1.
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
        // while the queue is not empty
        while (!queue.isEmpty()) {

            // accommodate for the number of subjects per term
            List<String> currentTerm =  new ArrayList<>();

            // Store the number of courses that can be added for the term
            // this will be smaller of the number set by user or the size of courses ready in the queue
            int termSize = Math.min(numCourses, queue.size());

            for (int i = 0; i < termSize; i++) {
                // set the current vertex to the first in the queue and add it to the result list.
                String current = queue.remove();
                currentTerm.add(current);

                // add to the courseCounter
                courseCounter++;

                // visit all courses that depend on the current course.
                for  (Edge edge : edges.get(current)) {
                    String to = edge.getTo();

                    // reduce the indegree of the dependent course by 1, as we have now processed one of its prerequisites.
                    indegree.put(to, indegree.get(to) - 1);

                    // if the indegree is now 0, that dependent course can be added to the queue.
                    if (indegree.get(to) == 0) {
                        queue.add(to);
                    }
                }
            }

            // Add processed course to the current term
            result.add(currentTerm);
        }

        // ensure all verticies have been processed, for a topological sort, there must not
        // be any cycles. The graph must be a Directed Acyclic Graph (DAG).
        // check if the size of the result list is the same size as the vertices.
        if (courseCounter != vertices.size()) {
            throw new RuntimeException("Graph has a cycle, topological sort not possible.");
        }

    // return the result of the sort.
    return result;
    }
}

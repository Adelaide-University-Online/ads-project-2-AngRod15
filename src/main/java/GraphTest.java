/**
 * File: GraphTest.java
 * Description: A unit test for the Graph class.
 * Author: Angie Rodley
 * Student ID: a3145754
 * Email ID: angie.rodley@student.adelaide.edu.au
 * AI Tool Used: Co-pilot in-line suggestions was turned on and Chat-GPT to help with Syntax of Kahn's Algorithm
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.Before;
import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * A class to test the methods in the Graph class
 * **/
public class GraphTest {

    // Create a graph to use in the tests.
    private Graph graph;

    @Before
    public void setUp() {
        graph = new Graph();
    }

    // Test adding a vertex
    @Test
    public void addVertex() {
        graph.addVertex("INFT1024");

            // Check that the vertex was added to the graph
        assertTrue(graph.getVertices().containsKey("INFT1024"));

    }

    // Test adding edges
    @Test
    public void addEdge() {
        // Add two vertices and an edge
        graph.addVertex("INFT1024");
        graph.addVertex("INFT1026");
        graph.addEdge("INFT1024", "INFT1026");

        // Variable to store the edge list
        List<Edge> edgeList = graph.getEdges().get("INFT1024");

        // check that there is one entry and the to and from are correct
        assertEquals(1, edgeList.size());
        assertEquals("INFT1026", edgeList.get(0).getTo());
        assertEquals("INFT1024", edgeList.get(0).getFrom());
    }

    // Test the topological search
    @Test
    public void topoSort() {

        // Add some vertices and edges to the graph
        graph.addVertex("COMP1043");
        graph.addVertex("COMP1048");
        graph.addVertex("INFT1024");

        graph.addEdge("COMP1043", "COMP1048");
        graph.addEdge("COMP1048", "INFT1024");

        // sort by one course per term
        List<List<String>> result = graph.topoSort(1);

        // There should be 3 courses listed
        assertEquals(3, result.size());

        // Check that the courses are in the correct order
        assertEquals("COMP1043", result.get(0).get(0));
        assertEquals("COMP1048", result.get(1).get(0));
        assertEquals("INFT1024", result.get(2).get(0));
    }

    // Test that the search throws and error if there is a cycle
    @Test(expected = RuntimeException.class)
    public void topoSortCycleException() {
        graph.addVertex("COMP1043");
        graph.addVertex("COMP1048");

        // add edges ina cycle
        graph.addEdge("COMP1043", "COMP1048");
        graph.addEdge("COMP1048", "COMP1043");

        // This should throw an exception
        graph.topoSort(1);

        // Baeldung, March 2025, Assert an Exception Is Thrown in JUnit 4 and 5,
        // https://www.baeldung.com/junit-assert-exception
    }


}
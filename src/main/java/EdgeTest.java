/**
 * File: EdgeTest.java
 * Description: A unit test for the Edge class.
 * Author: Angie Rodley
 * Student ID: a3145754
 * Email ID: angie.rodley@student.adelaide.edu.au
 * AI Tool Used: Co-pilot in-line suggestions was turned on and Chat-GPT to help with Syntax of Kahn's Algorithm
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * A class to test the methods in the Edge class
 * **/
public class EdgeTest {

    // Create edges to use in tests
    private Edge edge1;
    private Edge edge2;
    private Edge edge3;

    @Before
    public void setUp() {
        edge1 = new Edge("INFT1024", "INFT1026");
        edge2 = new Edge("COMP1043", "INFT1032");
        edge3 = new Edge("INFT1024", "INFT1026"); // Same as edge 1
    }

    // Test the getFrom method
    @Test
    public void getFrom() {
        assertEquals("INFT1024", edge1.getFrom());
    }

    // Test the getTo method
    @Test
    public void getTo() {
        assertEquals("INFT1032", edge2.getTo());
    }

    // Test the getWeight method
    @Test
    public void getWeight() {
        assertEquals(1, edge1.getWeight());
    }

    // Test the toString method
    @Test
    public void testToString() {
        assertEquals("Edge(INFT1024 -> INFT1026, weight = 1)", edge1.toString());
    }

    // Test the equals Override method
    // Confirm Equals and Not Equals
    @Test
    public void testEquals() {
        assertEquals(edge1, edge3);
        assertNotEquals(edge1, edge2);
    }

    // Test the HashCode override
    // Confirm Equals and NotEquals
    @Test
    public void testHashCode() {
        assertEquals(edge1.hashCode(), edge3.hashCode());
        assertNotEquals(edge1.hashCode(), edge2.hashCode());
    }
}
/**
 * File: VertexTest.java
 * Description: A unit test for the Vertex class.
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
 * A class to test the methods in the Vertex class
 **/
public class VertexTest {

    // Create some vertices to use in tests
    private Vertex vertex1;
    private Vertex vertex2;
    private Vertex vertex3;

    @Before
    public void setUp() {
        vertex1 = new Vertex("INFT1024");
        vertex2 = new Vertex("COMP1043");
        vertex3 = new Vertex("INFT1024"); // Same as vertex1
    }

    // Test the getCourseCode method
    @Test
    public void getCourseCode() {
        assertEquals("INFT1024", vertex1.getCourseCode());
    }

    // test the toString override
    @Test
    public void testToString() {
        assertEquals("Vertex(Course Code = INFT1024)", vertex1.toString());
    }

    // test the hashCode override
    // Confirm equals and not equals
    @Test
    public void testHashCode() {
        assertEquals(vertex1.hashCode(), vertex3.hashCode());
        assertNotEquals(vertex1.hashCode(), vertex2.hashCode());
    }

    // Test the equals override
    // Confirm Equals and Not Equals
    @Test
    public void testEquals() {
        assertEquals(vertex1, vertex3);
        assertNotEquals(vertex1, vertex2);
    }
}
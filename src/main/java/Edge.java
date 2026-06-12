import java.util.Objects;

/**
 * File: Edge.java
 * Description: A class to represent an edge in a graph.
 * Author: Angie Rodley
 * Student ID: a3145754
 * Email ID: angie.rodley@student.adelaide.edu.au
 * AI Tool Used: Co-pilot in-line suggestions was turned on and Chat-GPT to help with Syntax of Kahn's Algorithm
 * This is my own work as defined by
 *    the University's Academic Integrity Policy.
 **/

/**
 * This class represents an Edge in a graph.
 * An Edge is a connection between two courses, representing a course and its prerequisite.
 **/
public class Edge {
    private String from;
    private String to;
    private int weight;

    /**
     * Constructor for creating an edge
     * @param from The course that is the prerequisite.
     * @param to The course that depends on the prerequisite.
     * **/
    public Edge(String from, String to) {
        this.from = from;
        this.to = to;
        this.weight = 1;
    }

    // getter for From - this is the prerequisite course
    public String getFrom() {
        return from;
    }

    // getter for To - this is the course dependent on the prerequisite
    public String getTo() {
        return to;
    }

    // getter for weight - in this case all are equal weights. - Unweighted graph
    public int getWeight() {
        return weight;
    }

    // Override the toString method to provide a string representation ot the edge
    @Override
    public String toString() {
        return "Edge(" +
                from + " -> " +
                to + ", weight = " +
                weight + ')';
    }

    // override the equals
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Edge edge = (Edge) obj;
        return Objects.equals(from, edge.from) && Objects.equals(to, edge.to) && weight == edge.weight;
    }

    // Override the hashCode
    // At this stage all weights are set to a default of 1, however the weight has been included in the
    // HashCode calculation should the graph need to be weighted.
    @Override
    public int hashCode() {
        return Objects.hash(from, to, weight);
    }
}


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


public class Edge {
    private String from;
    private String to;
    private int weight;

    public Edge(String from, String to) {
        this.from = from;
        this.to = to;
        this.weight = 1;
    }

    // getter for From
    public String getFrom() {
        return from;
    }

    // getter for To
    public String getTo() {
        return to;
    }

    // getter for weight - in this case all are equal weights.
    public int getWeight() {
        return weight;
    }

    // Override the toString method to provide a string representation ot the edge
    @Override
    public String toString() {
        return "Edge(" + from + " -> " + to + ", weight = " + weight + ')';
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

        return Objects.equals(from, edge.from) && Objects.equals(to, edge.to);
    }

    // Override the hashCode
    @Override
    public int hashCode() {
        return Objects.hash(from, to);
    }
}


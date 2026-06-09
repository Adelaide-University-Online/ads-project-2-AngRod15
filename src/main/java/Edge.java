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
        return "Edge{" + "from='" + from + '\'' + ", to='" + to + '\'' + ", weight=" + weight + '}';
    }
}

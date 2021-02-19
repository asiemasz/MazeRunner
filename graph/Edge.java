package graph;

import java.util.Random;

public class Edge implements  Comparable<Edge> {
    private final Node start;
    private final Node end;
    private int weight;
    private static final int MAX_WEIGHT = 10;

    public Edge(Node start, Node end) {
        Random rand = new Random();
        this.start = start;
        this.end = end;
        this.weight = rand.nextInt(MAX_WEIGHT) + 1;
    }

    public Edge(Node start, Node end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    public Node getStart() {
        return start;
    }

    public Node getEnd() {
        return end;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
    
    @Override
    public String toString() {
    	return start.getX() + ", " + start.getY() + " -- " + end.getX() + ", " + end.getY() + " : " + weight;
    }
}

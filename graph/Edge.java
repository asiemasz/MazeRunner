package graph;

import java.util.Random;

public class Edge implements  Comparable<Edge> {
    private Node start;
    private final Node end;
    private int weight;

    public Edge(Node start, Node end) {
        Random rand = new Random();
        this.start = start;
        this.end = end;
        this.weight = rand.nextInt(11) + 1;
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

    public void print() {
        System.out.println(start.getX() + " ," + start.getY() + "; " + end.getX() + end.getY() + " : " + this.weight);
    }

    @Override
    public int compareTo(Edge edge) {
        return this.weight - edge.weight;
    }
}

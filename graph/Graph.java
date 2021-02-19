package graph;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes;
    ArrayList<Edge> edges;
    int size;
    int id;

    public Graph() {
        id = 0;
        size = 0;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        node.setId(id++);
        nodes.add(node);
        size++;
    }

    public void addEdge(Node start, Node end) {
        edges.add(new Edge(start,end));
    }

    public void addEdge(Node start, Node end,int weight) {
        edges.add(new Edge(start,end,weight));
    }
}

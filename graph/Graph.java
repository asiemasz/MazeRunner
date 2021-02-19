package graph;

import java.util.ArrayList;

public class Graph {
    ArrayList<Node> nodes;
    ArrayList<Edge> edges;
    int size;


    public Graph() {
        size = 0;
        nodes = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addNode(Node node) {
        nodes.add(node);
        size++;
    }

    public void addEdge(Node start, Node end) {
        edges.add(new Edge(start,end));
    }

    public void addEdge(Node start, Node end,int weight) {
        edges.add(new Edge(start,end,weight));
    }
    
    public void generateRandomRectGraph(int length, int width) {
        int nodesAmount = length * width;
        int x = 0;
        int y = 0;
        int id = 0;


        while(nodes.size() < nodesAmount) {
            if(y > length - 1) {
                x++;
                y = 0;
            }
            addNode(new Node(x, y, id++)); //add new Node
            if(y > 0) { //if there is a node above, add edge
                addEdge(nodes.get(size - 1), nodes.get(size - 2));
            }
            if(x > 0) { //if there is a node at left, add edge
                addEdge(nodes.get(size - 1), nodes.get(size - length - 1));
            }
            y++;
        }
        /**  Check correctness
        System.out.println("Nodes: ");
        for(int i = 0; i < nodes.size(); i++) {
            System.out.println(nodes.get(i).getX() + ", " + nodes.get(i).getY() + "  (" + nodes.get(i).getId() + ")");
        }
        System.out.println("Edges: ");
        for(int i = 0; i < edges.size(); i++) {
            System.out.println(edges.get(i).getStart().getX() + ", " + edges.get(i).getStart().getY() + " -- " + edges.get(i).getEnd().getX() + ", " + edges.get(i).getEnd().getY() + ": " + edges.get(i).getWeight());
        }
	*/
    }
}

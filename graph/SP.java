package graph;

import java.util.ArrayList;

public interface SP {
	ArrayList<Edge> getSPEdges(Graph gr, Node startNode, Node endNode);
}

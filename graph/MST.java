package graph;

import java.util.ArrayList;

public interface MST {
	int MAX_WEIGHT = Integer.MAX_VALUE;
	
	ArrayList<Edge> getMstEdges(Graph gr, Node startNode);
}

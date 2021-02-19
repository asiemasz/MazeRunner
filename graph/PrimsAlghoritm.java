package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;


public class PrimsAlghoritm implements MST {
	public ArrayList<Edge> getMstEdges(Graph gr, Node startNode) {
		ArrayList<Edge> mst = new ArrayList<>();
		int[][] adjMatrix = gr.getAdjacencyMatrix();
		ArrayList<Node> nodes = gr.getNodes();
		
		boolean[] selected = new boolean[adjMatrix.length];
		Arrays.fill(selected, false);
		
		if (startNode.getX() != 0) {
			throw new IllegalArgumentException("Illegal starting node");
		}
		
		int index = startNode.getId();
		
		selected[index] = true;
		
		while (mst.size() < adjMatrix.length - 1) {
			int min = MAX_WEIGHT;
			int x = 0;
			int y = 0;
			
			for (int i = 0; i < adjMatrix.length; i++) {
				if (selected[i] == true) {
					for (int j = 0; j < adjMatrix.length; j++) {
						if(!selected[j] && adjMatrix[i][j] != 0) {
							if ( adjMatrix[i][j] < min) {
								min = adjMatrix[i][j];
								x = i;
								y = j;
							}
						}
					}
				}
			}
			selected[y] = true;
			mst.add(new Edge(nodes.get(x), nodes.get(y), adjMatrix[x][y]));
		}
		
		return mst;
	}
}

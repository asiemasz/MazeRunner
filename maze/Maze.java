package maze;

import graph.*;
import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;

public class Maze {
	private int height;
	private int width;
	private int[][] maze;
	
	public Maze(int height, int width) {
		this.height = height;
		this.width = width;
		maze = new int[height][width];
		for(int i = 0; i < maze.length; i++) {
			Arrays.fill(maze[i], 1);
		}
	}
	
	public void print() {
		for (int i = 0; i < height; i++ ) {
			for (int j = 0; j < width; j++) {
				System.out.print(maze[i][j] == 1 ? "\u2588\u2588" : "  ");
			}
			System.out.println();
		}
	}
	
	public void generate() {
		int graphHeight = height % 2 == 0 ? (height - 1) / 2 : height / 2;
		int graphWidth = width % 2 == 0 ? (width - 1) / 2 : width / 2;
		
		Graph graph = new Graph();
		graph.generateRandomRectGraph(graphHeight, graphWidth);
		
		PrimsAlghoritm prim = new PrimsAlghoritm();
		Random random = new Random();
		int entranceIndex = random.nextInt(graphHeight);
		int outranceIndex = 0;
		
		ArrayList<Edge> mstEdges = prim.getMstEdges(graph, graph.getNodes().get(entranceIndex));
		for(Edge edge : mstEdges) {
			if(edge.getEnd().getX() == graphWidth - 1) {
				outranceIndex = edge.getEnd().getX();
			}
			else if(edge.getStart().getX() == graphWidth - 1) {
				outranceIndex = edge.getStart().getX();
			}
			int y1 = edge.getStart().getY() / graphHeight * 2 + 1;
            int x1 = (edge.getStart().getX() % graphWidth) * 2 + 1;
            int y2 = edge.getEnd().getY() / graphHeight * 2 + 1;
            int x2 = (edge.getEnd().getX() % graphWidth) * 2 + 1;
            int y = y1 == y2 ? y1 : (y1 + y2) / 2;
            int x = x1 == x2 ? x1 : (x1 + x2) / 2;
            maze[y][x] = 0;
            maze[y1][x1] = 0;
            maze[y2][x2] = 0;
		}
		maze[entranceIndex][0] = 0;
		maze[outranceIndex][width - 1] = 0;
	}
	
	
}

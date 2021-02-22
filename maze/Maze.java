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
		int outranceIndex = graphHeight / 2;
		int entranceIndex = 0;
		
		ArrayList<Edge> mstEdges = prim.getMstEdges(graph, graph.getNodes().get(random.nextInt(graphHeight - 1) + 1));
		for(Edge edge : mstEdges) {
			
			int x1 = edge.getStart().getX();
			int y1 = edge.getStart().getY();
			int x2 = edge.getEnd().getX();
			int y2 = edge.getEnd().getY();
			maze[y1 * 2 + 1][x1 * 2 + 1] = 0;
			maze[y1 + y2 + 1][x1 + x2 + 1] = 0;
			maze[y2 * 2 + 1][x2 * 2 + 1] = 0;
			if(x1 == 1) {
				entranceIndex = y1 * 2 + 1;
			}
			if(x1 * 2 + 1 == width - 2) {
				outranceIndex = y1 * 2 + 1;
			}
			else if(x2 * 2 + 1 == width - 2) {
				outranceIndex = y2 * 2 + 1;
			}
			else if(x1 + x2 + 1 == width - 2) {
				outranceIndex = y1 + y2 + 1;
			}
			
		}

		maze[entranceIndex][0] = 0;
		maze[outranceIndex][width - 1] = 0;
		if(width % 2 == 0) {
			maze[outranceIndex][width - 2] = 0;
		}
		
	}

	public int getHeight() {
		return height;
	}

	public int getWidth() {
		return width;
	}

	public int[][] getMaze() {
		return maze;
	}
	
	
}

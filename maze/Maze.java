package maze;

public class Maze {
	private int height;
	private int width;
	private int[][] maze;
	
	public Maze(int height, int width) {
		this.height = height;
		this.width = width;
		maze = new int[height][width];
	}
	
	public void print() {
		for (int i = 0; i < height; i++ ) {
			for (int j = 0; j < width; j++) {
				System.out.print(maze[i][j] == 1 ? "\u2588\u2588" : "  ");
			}
			System.out.println();
		}
	}
	
	
}

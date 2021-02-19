package maze;

public class Main {

	public static void main(String[] args) {
		Maze maze = new Maze(100,60);
		maze.generate();
		maze.print();
	}

}

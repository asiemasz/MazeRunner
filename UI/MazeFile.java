package UI;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import maze.Maze;

public class MazeFile implements Files {
	private Maze maze;
	
	public void setMaze(Maze maze) {
		this.maze = maze;
	}
	public Maze getMaze() {
		return maze;
	}
	public void loadFile(String filename) {
		File file = new File("./mazes/" + filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			int x = sc.nextInt();
			int y = sc.nextInt();
			sc.nextLine();
			int[][] mazeArray = new int[x][y];
			String intString;
			for (int i = 0; i < mazeArray.length; i++) {
				intString = sc.nextLine();
				for (int j = 0; j < intString.length(); j++) {
					mazeArray[i][j] = intString.charAt(j) - 48;
				}
			}
			maze =  new Maze(x, y, mazeArray);
			
		}
		catch (FileNotFoundException e) {
			System.out.println("The file " + filename + " does not exist");
		}
		catch (Exception e) {
			System.out.println("Error at loadFile(): " + e.getMessage());
		}
		finally {
			sc.close();
		}
	}
	public void saveFile(String filename) {
		File dir = new File("./mazes");
		if(!dir.exists()) {
			dir.mkdir();
		}
		File file = new File("./mazes/" + filename);
		try (FileWriter writer = new FileWriter(file, false)) {
			writer.write(maze.getHeight() + " " + maze.getWidth() + "\n");
			writer.write(maze.toString());
		} 
		catch (IOException e) {
			System.out.println("IOException at saveFile(): " + e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Error at saveFile()");
		}
	}
	


}

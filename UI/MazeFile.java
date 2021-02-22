package UI;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import maze.Maze;

public class MazeFile implements Files {
	private Maze maze;
	
	public MazeFile(Maze maze) {
		this.maze = maze;
	}
	
	public void loadFile(String filename) {
		File file = new File("/mazes/" + filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			loadMazeFromFile(file, sc);
		}
		catch (FileNotFoundException e) {
			System.out.println("The file " + filename + " does not exist");
		}
		catch (Exception e) {
			System.out.println("Error at loadFile()");
		}
		finally {
			sc.close();
		}
	}
	public void saveFile(String filename) {
		File file = new File("/mazes" + filename);
		Scanner sc = null;
		try {
			sc = new Scanner(file);
			loadMazeToFile(file, sc);
		}
		catch (FileNotFoundException e) {
			System.out.println("The file " + filename + " does not exist");
		}
		catch (Exception e) {
			System.out.println("Error at loadFile()");
		}
		finally {
			sc.close();
		}
	}
	
	private void loadMazeFromFile(File file, Scanner sc) throws FileNotFoundException { 
		
	}
	private void loadMazeToFile(File file, Scanner sc) throws FileNotFoundException {
		
	}
}

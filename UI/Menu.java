package UI;

import java.util.Scanner;
import maze.Maze;
import UI.MazeFile;

public class Menu {
	private String[] options;
	private int selectedOption;
	private boolean mazeExists = false;
	Maze maze;
	Scanner sc;
	
	public Menu() {
		options = new String[6];
		options[0] = "1. Generate a new maze";
		options[1] = "2. Load a maze";
		options[2] = "3. Save the maze";
		options[3] = "4. Display the maze";
		options[4] = "5. Find the escape";
		options[5] = "0. Exit";
		sc = new Scanner(System.in);
	}
	
	public void print() {
		int size = mazeExists == false ? 3 : 6;
		System.out.println("=== Menu ===");
		for(int i = 0; i < size - 1; i++) {
			System.out.println(options[i]);
		}
		System.out.println(options[5]);
	}
	
	public void selectOption() {
		int x = -1;
		try {
			x = sc.nextInt();
			sc.nextLine();
			if (x < 0 || x > ( mazeExists ? 5 : 2 )) {
				throw new IllegalArgumentException("Incorrect option. Please try again");
			}
			selectedOption = x;
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Incorrect option. Please try again");
		}
	}
	
	public void doAction() {
		switch(selectedOption) {
		case 0:
			programExit();
			break;
		case 1:
			generateMaze();
			break;
		case 2:
			loadMaze();
			break;
		case 3:
			saveMaze();
			break;
		case 4:
			maze.print();
			break;
		case 5:
			printEscape();
			break;
			 
		default:
			throw new RuntimeException("Something's wrong - doAction()");
		}
	}
	
	private void programExit() {
		java.lang.System.exit(0);
		sc.close();
	}
	
	private void generateMaze() {
		System.out.println("Enter the size of a new maze");
		int x = Integer.parseInt(sc.nextLine());
		maze = new Maze(x, x);
		maze.generate();
		mazeExists = true;
		maze.print();
	}
	
	private void loadMaze() {
		String filename = sc.nextLine();
		MazeFile  mazefile = new MazeFile();
		mazefile.loadFile(filename);
		maze = mazefile.getMaze();
		mazeExists = true;
		
	}
	
	private void saveMaze() {
		while(!sc.hasNextLine());
		String filename = sc.nextLine();
		MazeFile mazefile = new MazeFile();
		mazefile.setMaze(maze);
		mazefile.saveFile(filename);
	}
	
	private void printEscape() {
		try {
			Maze solvedMaze = (Maze) maze.clone();
			int [][] mazeArray = solvedMaze.getMaze();
			int y = 0;
			for (int i = 0; i < mazeArray.length; i++) {
				if (mazeArray[i][0] == 0) {
					y = i;
				}
			}
			solvedMaze.solveMaze(0, y);
			solvedMaze.printSolvedMaze();
		}
		catch (CloneNotSupportedException e) {
			System.out.print("CloneNotSupported (Maze)");
		}
	}
	
}

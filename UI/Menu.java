package UI;

import java.util.Scanner;

public class Menu {
	private String[] options;
	private int selectedOption;
	private boolean mazeLoaded = false;
	
	public Menu() {
		options = new String[5];
		options[0] = "1. Generate a new maze";
		options[1] = "2. Load a maze";
		options[2] = "3. Save the maze";
		options[3] = "4. Display the maze";
		options[4] = "0. Exit";
	}
	
	public void print() {
		int size = mazeLoaded == false ? 3 : 5;
		System.out.println("=== Menu ===");
		for(int i = 0; i < size - 1; i++) {
			System.out.println(options[i]);
		}
		System.out.println(options[4]);
	}
	
	public void selectOption() {
		Scanner sc = new Scanner(System.in);
		int x = -1;
		try {
			x = sc.nextInt();
			if (x < 0 || x > ( mazeLoaded ? 4 : 2 )) {
				throw new IllegalArgumentException("Incorrect option. Please try again");
			}
		}
		catch(IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
		catch(Exception e) {
			System.out.println("Incorrect option. Please try again");
		}
		finally {
			sc.close();
		}
		selectedOption = x;
	}
	
	public void doAction() {
		switch(selectedOption) {
		case 0:
			//exit
			break;
		case 1:
			//generateMaze
		case 2:
			//load a maze
		case 3:
			//save a maze
		case 4:
			//display maze
		default:
			throw new RuntimeException("Something's wrong - doAction()");
		}
	}
	
}

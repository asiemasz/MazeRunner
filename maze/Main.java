package maze;

import UI.Menu;

public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		while(true) {
			menu.print();
			menu.selectOption();
			menu.doAction();
		}
	}

}

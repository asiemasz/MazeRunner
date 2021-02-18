package graph;

public class Node {
	private int x;
	private int y;
	private int id;
	
	public Node(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Node(int x, int y, int id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}
	
	
}

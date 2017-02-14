package datastructure.line.stackApplication;

/**
 * 点位
 * @author wangning
 *
 */
public class Cell {
	
	// 单元所在行
	private int x;  
	
	// 单元所在列
	private int y;
	
	// 该单元是否访问过
	private boolean visited = false;
	
	// 1 代表墙， 0代表可以通过的路  *代表走过的路
	private char c = ' ';

	public Cell(int x, int y, boolean visited, char c) {
		super();
		this.x = x;
		this.y = y;
		this.visited = visited;
		this.c = c;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public char getC() {
		return c;
	}

	public void setC(char c) {
		this.c = c;
	}
	
}

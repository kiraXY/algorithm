package datastructure.line.stackApplication;

import datastructure.line.stack.StackArray.StackArray;

/**
 * 迷宫问题
 * @author wangning
 *
 */
public class Maze {
	
	// 起始坐标
	private Cell start;

	// 重点坐标
	private Cell end;
	
	// 构件堆栈
	private StackArray<Cell> stack;
	
	// 构件坐标数组
	private Cell[][] cells;
	
	public Maze(Cell start, Cell end, char[][] maze) {
		this.start = start;
		this.end = end;
		
		this.stack = new StackArray<Cell>();
		
		cells = createCellArray(maze);
		
		
	}
	
	public void mazeExit() {
		// 起点入栈 
		stack.push(start);
		// 设置起点已经访问
		start.setVisited(true);
		
		// 设置当前坐标
		Cell current;
		
		while(!stack.isEmpty()) {
			current = stack.peek();
			
			if(current.getX() == end.getX() && current.getY() == end.getY()) {
				// 将栈中的坐标全部弹出 修改 状态值值
				while(!stack.isEmpty()) {
					
					// 获取第一个元素
					Cell c1 = stack.pop();
					c1.setC('*');
					
					// 清楚记录但是没有探索的格子
					while(!stack.isEmpty() && !isAdJoinell(c1, stack.peek())) stack.pop();
					
				}
				
				printMaze(cells);
				
			} else {
				
				
				int x = current.getX();
				int y = current.getY();
				int count = 0;
				// 向下
				if(isValid(cells[x + 1][y])) {
					stack.push(cells[x + 1][y]);
					cells[x + 1][y].setVisited(true);
					count ++;
				}
				// 向左
				if(isValid(cells[x][y - 1])) {
					stack.push(cells[x][y - 1]);
					cells[x][y - 1].setVisited(true);
					count ++;
				}
				// 向上
				if(isValid(cells[x - 1][y])) {
					stack.push(cells[x - 1][y]);
					cells[x - 1][y].setVisited(true);
					count ++;
				}
				// 向右边
				if(isValid(cells[x][y + 1])) {
					stack.push(cells[x][y + 1]);
					cells[x][y + 1].setVisited(true);
					count ++;
				}
				
				// 四个方向都走不通 则当前坐标出栈
				if(count == 0) stack.pop();
			}
		}
		
	}
	
	/**
	 * 判断 格子状态是可行
	 * 
	 * 判断 格子是否走过
	 * @param c
	 * @return
	 */
	private boolean isValid(Cell c) {
		return c.getC() == '0' && !c.isVisited();
	}
	
	

	/**
	 * 辅助从终点往前推
	 * 
	 * 只有在坐标周围的才是 直接通往终点的路劲
	 * 
	 * 由于栈会压入所有可能的路径，当第一个最近坐标被确认就会弹出，下次取出的坐标就和被弹出的 坐标就不会匹配上所以 有些可能坐标就会别去除，只剩一个正确坐标
	 * （入栈顺序是下左上右， 可能的坐标都会被记录， 所以最后逆推时，只会取最近的一个正确坐标，而其他的可能坐标会被规则排除）
	 * 
	 * 
	 * @param c1
	 * @param c2
	 * @return
	 */
	private boolean isAdJoinell(Cell c1, Cell c2) {
		if(c1.getX() == c2.getX() && Math.abs(c1.getY() - c2.getY()) < 2) return true;
		if(c1.getY() == c2.getY() && Math.abs(c1.getX() - c2.getX()) < 2) return true;
		
		return false;
	}
	
	
	/**
	 * 打印迷宫
	 */
	private void printMaze(Cell[][] a) {
		
		for (int i = 0; i < a.length; i++) {
			Cell[] cells = a[i];
			
			for (int j = 0; j < cells.length; j++) {

				System.out.print(" " + cells[j].getC() + " ");
			}
			
			System.out.println();
			
		}
	}
	
	/**
	 * 创建点位 数组（Cell）
	 * @param maze
	 * @return
	 */
	private Cell[][] createCellArray(char[][] maze) {
		// 初始化数组
		Cell[][] cells = new Cell[maze.length][];
		
		for (int i = 0; i < cells.length; i++) {
			// 获取行
			char[] row = maze[i];
				
			// 创建点位数组 (列)  为点位数组的每一行 增加列数   
			cells[i] = new Cell[row.length];
			for (int j = 0; j < row.length; j++) {
				// 初始化点位信息
				cells[i][j] = new Cell(i, j, false, maze[i][j]);
			}
		}
		
		return cells;
	}
	
	public static void main(String[] args) {
		System.out.println("迷宫开始");
		
		char[][] maze = new char[10][];
		
		maze[0] = new char[]{'1','1','1','1','1','1','1','1','1','1'};
		
		maze[1] = new char[]{'1','0','0','1','1','1','0','0','1','1'};
		
		maze[2] = new char[]{'1','0','0','1','1','0','0','1','0','1'};
		
		maze[3] = new char[]{'1','0','0','0','0','0','0','1','0','1'};
		
		maze[4] = new char[]{'1','0','0','0','0','1','1','0','0','1'};
		
		maze[5] = new char[]{'1','0','0','1','1','1','0','0','0','1'};
		
		maze[6] = new char[]{'1','0','0','0','0','1','0','1','0','1'};
		
		maze[7] = new char[]{'1','0','1','1','0','0','0','1','0','1'};
		
		maze[8] = new char[]{'1','1','0','0','0','0','1','0','0','1'};
		
		maze[9] = new char[]{'1','1','1','1','1','1','1','1','1','1'};
		
		
		// 起点坐标
		Cell start = new Cell(2, 8, false, '0');
		
		// 终点坐标
		Cell end = new Cell(1, 7, false, '0');
		
		Maze m = new Maze(start, end, maze);
//		Cell[][] cells = m.createCellArray(maze);
		
		System.out.println("=================================");
		// 打印迷宫
//		m.printMaze(cells);
		m.mazeExit();
		System.out.println("=================================");

	}
}

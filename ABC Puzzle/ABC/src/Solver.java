import java.util.Scanner;

/**
 * This class takes input and prints the output
 * @author saimaddhi
 *
 */
public class Solver {
	/**
	 * This is the grid containing all values
	 */
	private String[][] grid = new String[6][6];
	/**
	 * This is the user's input String
	 */
	private String[] inputVals;
	/**
	 * This is an array of the three values that are possible to fill the grid with
	 */
	private String[] letters = {"A", "B", "C"};
	/**
	 * This default constructor takes the users input and solves the grid and prints the output
	 */
	public Solver() {
		Scanner input = new Scanner(System.in);
		for(int i = 1; i <= 5; i++) {
			System.out.println("Enter your numbers");
			inputVals = input.nextLine().split(", ");
			initGrid(inputVals);
		}
	}
	/**
	 * This method sets the given cell with the given value
	 * @param num this is the cell number
	 * @param val this is the value
	 */
	public void setCell(int num, String val) {
		num--;
		int row = num / 6;
		int col = num % 6;
		grid[row][col] = val;
	}
	/**
	 * This method gets the column number of a given cell
	 * @param num this is the cell number
	 * @return this is the column number returned
	 */
	public int getCol(int num) {
		num--;
		return num%6;
	}
	/**
	 * This method gets the row number of a given cell
	 * @param num this is the cell number
	 * @return this is the row number returned
	 */
	public int getRow(int num) {
		num--;
		return num/6;
	}
	/**
	 * This method returns the value in the cell at this number
	 * @param num this is the cell number
	 * @return this is the value inside the cell
	 */
	public String getCell(int num) {
		num--;
		int row = num / 6;
		int col = num % 6;
		return grid[row][col];
	}
	/**
	 * This method checks if a given value can go in a given row
	 * @param r this is the row number
	 * @param val this is the value
	 * @return true/false the value can go in this row
	 */
	public boolean checkRow(int r, String val) {
		for(int c = 1; c < 5; c++) {
			if(grid[r][c].equals(val)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * This method checks if a given value can go in a given column
	 * @param c this is the column number
	 * @param val this is the value
	 * @return true/false the value can go in this column
	 */
	public boolean checkCol(int c, String val) {
		for(int r = 1; r < 5; r++) {
			if(grid[r][c].equals(val)) {
				return false;
			}
		}
		return true;
	}
	/**
	 * This method checks whether or not a given value can go in a given cell
	 * @param r this is the row number of the given cell
	 * @param c this is the column number of the given cell
	 * @param val this is the value
	 * @return true/false this value can go in this given cell
	 */
	public boolean isAllowed(int r, int c, String val) {
		return checkRow(r, val) && checkCol(c, val);
	}
	/**
	 * This method prints the solution
	 */
	public void printSolution() {
		for(int r = 1; r < grid.length-1; r++) {
			for(int c = 1; c < grid[0].length-1; c++) {
				if(!grid[r][c].equals("X")) {
					System.out.print(grid[r][c]);
				}
			}
		}
		System.out.println();
	}
	/**
	 * This method fills the grid with empty values
	 */
	public void fillGrid() {
		for(int r = 0; r < 6; r++) {
			for(int c = 0; c < 6; c++) {
				grid[r][c] = "";
			}
		}
	}
	/**
	 * This method prints the grid
	 */
	public void printGrid() {
		for(int r = 0; r < grid.length; r++) {
			for(int c = 0; c < grid[0].length; c++) {
				if(grid[r][c] == "") {
					System.out.print(" -");
				} else {
					System.out.print(" "+grid[r][c]);
				}
			}
			System.out.println();
		}
	}
	/**
	 * This method initializes the grid with the given input string
	 * @param vals this is the input string
	 */
	public void initGrid(String[] vals) {
		fillGrid();
		for(int i = 0; i <= 3; i++) {
			setCell(Integer.parseInt(vals[i]), "X");
		}
		int index = 5;
		for(int i = 1; i <= Integer.parseInt(vals[4]); i++) {
			int r = getRow(Integer.parseInt(vals[index+1]));
			int c = getCol(Integer.parseInt(vals[index+1]));
			if(r == 0) {
				if(!grid[r+1][c].equals("X")) {
					grid[r+1][c] = vals[index];
				} else {
					grid[r+2][c] = vals[index];
				}
			} else if(r == 5) {
				if(!grid[r-1][c].equals("X")) {
					grid[r-1][c] = vals[index];
				} else {
					grid[r-2][c] = vals[index];
				}
			} else if(c == 0) {
				if(!grid[r][c+1].equals("X")) {
					grid[r][c+1] = vals[index];
				} else {
					grid[r][c+2] = vals[index];
				}
			} else {
				if(!grid[r][c-1].equals("X")) {
					grid[r][c-1] = vals[index];
				} else {
					grid[r][c-2] = vals[index];
				}
			}
			index+=2;
		}
		solve(1, 1);
	}
	/**
	 * This method calls solve on the next cell
	 * @param r
	 * @param c
	 */
	public void solveNextOne(int r, int c) {
		c++;
		if(c > 4) {
			c = 1;
			r++;
		}
		solve(r, c);
	}
	/**
	 * This method is main solver
	 * @param r this is the row of the cell it tries to solve
	 * @param c this is the column of the cell it tries to solve
	 */
	public void solve(int r, int c) {
		if(r > 4) {
			printSolution();
			printGrid();
		} else if (!grid[r][c].equals("")) {
			solveNextOne(r,c);
		} else {
			for(int i = 0; i < 3; i++) {
				if(isAllowed(r, c, letters[i])) {
					grid[r][c] = letters[i];
					solveNextOne(r, c);
				}
			}
			grid[r][c] = "";
		}
	}
}
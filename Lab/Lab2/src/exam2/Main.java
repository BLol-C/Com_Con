package exam2;

public class Main {

	public static void main(String[] args) {
		final int SIZE = 5;

		int[][] grid = new int[SIZE][SIZE];

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				grid[i][j] = i * SIZE + j + 1;
			}
		}

//		for (int i = 0; i < SIZE; i++) {
//			for (int j = 0; j < SIZE; j++) {
//				grid[j][i] = i * SIZE + j + 1; 
//			}
//		}

		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				if (i % 2 == 0)
					grid[i][j] = i * SIZE + j + 1;
				else
					grid[i][j] = i * SIZE + SIZE - j;
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}

	}
}

/**
 * 289. 生命游戏
 * https://leetcode.cn/problems/game-of-life/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class GameOfLife {
	public void gameOfLife(int[][] board) {
		int m = board.length - 1;
		int n = board[0].length - 1;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				int count = getLifeCount(board, m, n, i, j);
				if (board[i][j] == 0 && count == 3) {
					board[i][j] = 2;
				}
				else if (board[i][j] == 1 && (count < 2 || count > 3)) {
					board[i][j] = 1;
				}
				else if (board[i][j] == 1 && (count == 2 || count == 3)) {
					board[i][j] = 3;
				}
			}
		}

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				board[i][j] = board[i][j] >> 1;
			}
		}
	}

	public int getLifeCount(int[][] board, int m, int n, int i, int j) {
		int cnt = 0;
		for (int k = i - 1; k <= i + 1; k++) {
			for (int l = j - 1; l <= j + 1; l++) {
				if (k >= 0 && k <= m && l >= 0 && l <= n) {
					if (!(k == i && l == j) && (board[k][l] == 3 || board[k][l] == 1)) {
						cnt++;
					}
				}
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		GameOfLife gameOfLife = new GameOfLife();
		int[][] board = {
				{0, 1, 0},
				{0, 0, 1},
				{1, 1, 1},
				{0, 0, 0}
		};
		gameOfLife.gameOfLife(board);
		for (int[] ints : board) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println("\n");
		}
	}
}

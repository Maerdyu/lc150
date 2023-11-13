import java.util.HashMap;
import java.util.Map;

/**
 * 36. 有效的数独
 * https://leetcode.cn/problems/valid-sudoku/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsValidSudoku {


	public boolean isValidSudoku(char[][] board) {
		Map<Character, boolean[]> nm = new HashMap<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if(board[i][j] == '.'){
					continue;
				}
				boolean[] nba = nm.getOrDefault(board[i][j], new boolean[27]);
				int square = (i / 3 * 3 + j / 3) + 18;
				if(nba[i] || nba[j+9] || nba[square]){
					return false;
				}
				nba[i] = true;
				nba[j + 9] = true;
				nba[square] = true;
				nm.put(board[i][j], nba);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsValidSudoku isValidSudoku = new IsValidSudoku();
		char[][] board = {
				{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
				{'6', '.', '.', '1', '9', '5', '.', '.', '.'},
				{'.', '9', '8', '.', '.', '.', '.', '6', '.'},
				{'8', '.', '.', '.', '6', '.', '.', '.', '3'},
				{'4', '.', '.', '8', '.', '3', '.', '.', '1'},
				{'7', '.', '.', '.', '2', '.', '.', '.', '6'},
				{'.', '6', '.', '.', '.', '.', '2', '8', '.'},
				{'.', '.', '.', '4', '1', '9', '.', '.', '5'},
				{'.', '.', '.', '.', '8', '.', '.', '7', '9'}
		};
		boolean validSudoku = isValidSudoku.isValidSudoku(board);
		System.out.println(validSudoku);
	}
}

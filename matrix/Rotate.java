/**
 * 48. 旋转图像
 * https://leetcode.cn/problems/rotate-image/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Rotate {
	public void rotate(int[][] matrix) {
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;
		int row = 0, column = 0, k, next, temp;
		while (row < m && column < n) {
			int step = n - column;
			for (int i = row; i < n; i++) {
				// top
				k = step - (n - i) + row;
				next = matrix[k][n];
				matrix[k][n] = matrix[row][i];

				// right
				k = n - (step - (m - k));
				temp = matrix[m][k];
				matrix[m][k] = next;
				next = temp;

				// bottom
				k = m - (step - (k - column));
				temp = matrix[k][column];
				matrix[k][column] = next;
				next = temp;

				// left
				k = column + step - (k - row);
				matrix[row][k] = next;
			}
			row++;
			column++;
			m--;
			n--;
		}
	}

	public static void main(String[] args) {
		Rotate rotate = new Rotate();
		int[][] matrix = {
				{1, 2, 3},
				{4, 5, 6},
				{7, 8, 9}
		};
		rotate.rotate(matrix);
		for (int[] ints : matrix) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println("\n");
		}
	}
}

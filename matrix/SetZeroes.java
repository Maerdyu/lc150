/**
 * 73. 矩阵置零
 * https://leetcode.cn/problems/set-matrix-zeroes/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SetZeroes {

	public void setZeroes(int[][] matrix) {
		int m = matrix.length - 1;
		int n = matrix[0].length - 1;

		// 判断行 列是否存在0
		boolean c0 = false;
		for (int i = 0; i <= m; i++) {
			if (matrix[i][0] == 0) {
				c0 = true;
				break;
			}
		}
		boolean r0 = false;
		for (int i = 0; i <= n; i++) {
			if (matrix[0][i] == 0) {
				r0 = true;
				break;
			}
		}

		// 如果有0，设置到第一行第一列
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		// 修改行 列
		for (int i = 1; i <= m; i++) {
			if (matrix[i][0] == 0) {
				for (int j = 0; j <= n; j++) {
					matrix[i][j] = 0;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (matrix[0][i] == 0) {
				for (int j = 0; j <= m; j++) {
					matrix[j][i] = 0;
				}
			}
		}

		//更新行列
		if (r0) {
			for (int i = 0; i <= n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (c0) {
			for (int i = 0; i <= m; i++) {
				matrix[i][0] = 0;
			}
		}

	}

	public static void main(String[] args) {
		SetZeroes setZeroes = new SetZeroes();
		int[][] matrix = {
				{0, 1, 2, 0},
				{3, 4, 5, 2},
				{1, 3, 1, 5}
		};
		setZeroes.setZeroes(matrix);
		for (int[] ints : matrix) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println("\n");
		}
	}
}

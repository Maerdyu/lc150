import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 * https://leetcode.cn/problems/spiral-matrix/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class SpiralOrder {

	public List<Integer> spiralOrder(int[][] matrix) {
		int row = 0, column = 0, m = matrix.length - 1, n = matrix[0].length - 1;
		List<Integer> res = new ArrayList<>();
		while (row <= m && column <= n) {
			// top
			if (row <= m && column <= n) {
				int k = column;
				while (k <= n) {
					res.add(matrix[row][k++]);
				}
				row++;
			}
			// right
			if (row <= m && column <= n) {
				int k = row;
				while (k <= m) {
					res.add(matrix[k++][n]);
				}
				n--;
			}
			// down
			if (row <= m && column <= n) {
				int k = n;
				while (k >= column) {
					res.add(matrix[m][k--]);
				}
				m--;
			}
			// left
			if (row <= m && column <= n) {
				int k = m;
				while (k >= row) {
					res.add(matrix[k--][column]);
				}
				column++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		SpiralOrder spiralOrder = new SpiralOrder();
		int[][] matrix = {
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
		List<Integer> integers = spiralOrder.spiralOrder(matrix);
		for (Integer integer : integers) {
			System.out.println(integer);
		}
	}
}

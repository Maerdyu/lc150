/**
 * 6. N 字形变换
 * https://leetcode.cn/problems/zigzag-conversion/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class NConvert {
	// 使用二维数组模拟
	public String convert(String s, int numRows) {
		if(numRows == 1){
			return s;
		}

		int sn = s.length(), index = 0, i = 0, j = 0;
		int length = (sn / (2 * numRows - 1) + 1) * numRows;
		char[][] res = new char[numRows][length];
		boolean down = true;
		while (index < sn) {
			if (down) {
				while (index < sn && i < numRows) {
					res[i++][j] = s.charAt(index++);
				}
				i--;
				down = false;
			}
			else {
				while (index < sn && i > 0) {
					res[--i][++j] = s.charAt(index++);
				}
				i++;
				down = true;
			}
		}
		StringBuilder result = new StringBuilder();
		for (char[] re : res) {
			for (char c : re) {
				if (c != '\u0000') {
					result.append(c);
				}
			}
		}
		return result.toString();
	}

	// 巧设 flag

	public static void main(String[] args) {
		NConvert nConvert = new NConvert();
		String s = "AB";
		String convert = nConvert.convert(s, 1);
		System.out.println(convert);
	}
}

/**
 * 12. 整数转罗马数字
 * https://leetcode.cn/problems/integer-to-roman/description/
 */
public class TurnRomanNumerals {

	/**
	 * 贪心
	 * @param num 数字
	 * @return 罗马数字
	 */
	public String intToRoman(int num) {
		int[] n = {1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000};
		String[] symbol = {"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M"};

		StringBuilder res = new StringBuilder();
		for (int i = n.length-1; i >= 0; i--) {
			while (num >= n[i]){
				res.append(symbol[i]);
				num -= n[i];
			}
		}
		return res.toString();
	}

	public static void main(String[] args) {
		TurnRomanNumerals turnRomanNumerals = new TurnRomanNumerals();
		int num = 3;
		String s = turnRomanNumerals.intToRoman(num);
		System.out.println(s);
	}
}

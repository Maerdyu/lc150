/**
 * 202. 快乐数
 * https://leetcode.cn/problems/happy-number/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsHappy {
	public boolean isHappy(int n) {
		int i = n, j = n;
		do {
			i = getHappy(i);
			j = getHappy(getHappy(j));
			if (i == 1 || j == 1) {
				return true;
			}
		}
		while (i != j);
		return false;
	}

	private int getHappy(int n) {
		int sum = 0;
		while (n > 0) {
			sum += ((n % 10) * (n % 10));
			n = n / 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		IsHappy isHappy = new IsHappy();
		boolean happy = isHappy.isHappy(19);
		System.out.println(happy);
	}
}

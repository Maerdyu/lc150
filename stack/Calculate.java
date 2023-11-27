import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * https://leetcode.cn/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Calculate {
	public int calculate(String s) {
		Deque<Integer> numDeque = new ArrayDeque<>();
		Deque<Character> opDeque = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if(' '==s.charAt(i)){
				continue;
			}
			if (Character.isDigit(s.charAt(i))) {
				int sum = s.charAt(i) - '0';
				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					sum = sum *10 + (s.charAt(i+1)-'0');
					i++;
				}
				numDeque.push(sum);
				while (!opDeque.isEmpty() && ('+' == opDeque.peek() || '-' == opDeque.peek())) {
					Character pop = opDeque.pop();
					Integer pop1 = numDeque.pop();
					Integer pop2 = numDeque.pop();
					if ('+' == pop) {
						numDeque.push(pop2 + pop1);
					}
					else if ('-' == pop) {
						numDeque.push(pop2 - pop1);
					}
				}
			}
			else if (')' != s.charAt(i)) {
				opDeque.push(s.charAt(i));
			}
			else if (')' == s.charAt(i)) {
				opDeque.pop();
			}
		}

		while (!opDeque.isEmpty() && ('+' == opDeque.peek() || '-' == opDeque.peek())) {
			Character pop = opDeque.pop();
			Integer pop1 = numDeque.pop();
			Integer pop2 = numDeque.pop();
			if ('+' == pop) {
				numDeque.push(pop2 + pop1);
			}
			else if ('-' == pop) {
				numDeque.push(pop2 - pop1);
			}
		}

		return numDeque.pop();
	}

	public static void main(String[] args) {
		Calculate calculate = new Calculate();
		int calculate1 = calculate.calculate("2147483647+1");
		System.out.println(calculate1);
	}
}

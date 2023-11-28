import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. 基本计算器
 * https://leetcode.cn/problems/basic-calculator/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class Calculate {
	public int calculate(String s) {
		s = s.replace(" ", "");
		Deque<Long> numDeque = new ArrayDeque<>();
		Deque<Character> opDeque = new ArrayDeque<>();
		if(s.startsWith("+")||s.startsWith("-")){
			numDeque.push(0L);
		}
		for (int i = 0; i < s.length(); i++) {
			if (Character.isDigit(s.charAt(i))) {
				long sum = s.charAt(i) - '0';
				while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))){
					sum = sum *10 + (s.charAt(i+1)-'0');
					i++;
				}
				numDeque.push(sum);
				while (!opDeque.isEmpty() && ('+' == opDeque.peek() || '-' == opDeque.peek())) {
					char pop = opDeque.pop();
					Long pop1 = numDeque.pop();
					Long pop2 = 0L;
					if(!numDeque.isEmpty()){
						pop2 = numDeque.pop();
					}

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
				if('(' == s.charAt(i)){
					if(i+1 < s.length() && ('+' == s.charAt(i+1) || '-'==s.charAt(i+1))){
						numDeque.push(0L);
						opDeque.push(s.charAt(++i));
					}
				}

			}
			else if (')' == s.charAt(i)) {
				opDeque.pop();
				while (!opDeque.isEmpty() && ('+' == opDeque.peek() || '-' == opDeque.peek())) {
					char pop = opDeque.pop();
					Long pop1 = numDeque.pop();
					Long pop2 = 0L;
					if(!numDeque.isEmpty()){
						pop2 = numDeque.pop();
					}
					if ('+' == pop) {
						numDeque.push(pop2 + pop1);
					}
					else if ('-' == pop) {
						numDeque.push(pop2 - pop1);
					}
				}
			}
		}

		while (!opDeque.isEmpty() && ('+' == opDeque.peek() || '-' == opDeque.peek())) {
			char pop = opDeque.pop();
			Long pop1 = numDeque.pop();
			Long pop2 = 0L;
			if(!numDeque.isEmpty()){
				pop2 = numDeque.pop();
			}
			if ('+' == pop) {
				numDeque.push(pop2 + pop1);
			}
			else if ('-' == pop) {
				numDeque.push(pop2 - pop1);
			}
		}

		return Math.toIntExact(numDeque.pop());
	}

	public static void main(String[] args) {
		Calculate calculate = new Calculate();
		int calculate1 = calculate.calculate("- (3 + (4 + 5))");
		System.out.println(calculate1);
	}
}

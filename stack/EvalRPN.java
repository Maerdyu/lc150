import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 150. 逆波兰表达式求值
 * https://leetcode.cn/problems/evaluate-reverse-polish-notation/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class EvalRPN {
	public int evalRPN(String[] tokens) {
		Deque<Integer> deque = new ArrayDeque<>();
		for (String token : tokens) {
			if ("+".equals(token) || "-".equals(token) || "*".equals(token) || "/".equals(token)) {
				Integer pop2 = deque.pop();
				Integer pop1 = deque.pop();
				switch (token) {
				case "+" -> deque.push(pop1 + pop2);
				case "-" -> deque.push(pop1 - pop2);
				case "*" -> deque.push(pop1 * pop2);
				case "/" -> deque.push(pop1 / pop2);
				}
			}
			else {
				deque.push(Integer.valueOf(token));
			}
		}
		return deque.pop();
	}
}

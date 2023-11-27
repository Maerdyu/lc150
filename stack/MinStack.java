import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

	private Deque<Long> deque;
	private Long min;

	public MinStack() {
		deque = new ArrayDeque<>();
	}

	public void push(int val) {
		if (min == null) {
			min = (long) val;
		}
		deque.push(val - min);
		if (val < min) {
			min = (long) val;
		}
	}

	public void pop() {
		Long pop = deque.pop();
		if (pop < 0) {
			min = min - pop;
		}
	}

	public int top() {
		if (deque.isEmpty()) {
			return 0;
		}
		else {
			Long peek = deque.peek();
			if (peek < 0) {
				return Math.toIntExact(min);
			}
			return (int) (peek + min);
		}
	}

	public int getMin() {
		return Math.toIntExact(min);
	}

	public static void main(String[] args) {
		MinStack minStack = new MinStack();
		minStack.push(2147483646);
		minStack.push(2147483646);
		minStack.push(2147483647);
		minStack.top();
		minStack.pop();
		minStack.pop();
		minStack.push(2147483647);
		minStack.push(-2147483648);
		System.out.println(minStack.top());
		System.out.println(minStack.getMin());
	}
}

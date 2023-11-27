import java.util.ArrayDeque;
import java.util.Deque;

public class IsValid {
	public boolean isValid(String s) {
		Deque<Character> deque = new ArrayDeque<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '{' || s.charAt(i) == '[' || s.charAt(i) == '(') {
				deque.push(s.charAt(i));
			}else {
				if(deque.isEmpty()){
					return false;
				}
				char pop = deque.pop();
				if ((s.charAt(i) == '}' && pop == '{') || (s.charAt(i) == ']' && pop == '[') || (s.charAt(i) == ')' && pop == '(')) {
					continue;
				}
				else {
					return false;
				}
			}
		}
		return deque.isEmpty();
	}

	public static void main(String[] args) {
		IsValid isValid = new IsValid();
		boolean valid = isValid.isValid("()");
		System.out.println(valid);
	}
}

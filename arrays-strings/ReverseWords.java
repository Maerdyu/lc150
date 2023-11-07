import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 151. 反转字符串中的单词
 * https://leetcode.cn/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ReverseWords {

	// 栈
	public String reverseWords(String s) {
		int index = 0, sn = s.length();
		Deque<String> deque = new ArrayDeque<>();
		StringBuilder stb = new StringBuilder();
		while (index <= sn){
			if(index < sn && s.charAt(index) != ' '){
				stb.append(s.charAt(index));
			}else if(!stb.toString().equals("")){
				deque.push(stb.toString());
				stb = new StringBuilder();
			}
			index++;
		}

		StringBuilder res = new StringBuilder();
		while (!deque.isEmpty()){
			res.append(deque.pop()).append(" ");
		}
		return res.toString().trim();
	}

	// 双指针

	public static void main(String[] args) {
		ReverseWords reverseWords = new ReverseWords();
		String s = "a good   example";
		String s1 = reverseWords.reverseWords(s);
		System.out.println(s1);
	}
}

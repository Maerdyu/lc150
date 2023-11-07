/**
 * 58. 最后一个单词的长度
 * https://leetcode.cn/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LengthOfLastWord {

	public int lengthOfLastWord(String s) {
		String[] split = s.split("\\s+");
		return split[split.length-1].length();
	}

	public static void main(String[] args) {
		LengthOfLastWord lengthOfLastWord = new LengthOfLastWord();
		String s = "hello world";
		int length = lengthOfLastWord.lengthOfLastWord(s);
		System.out.println(length);
	}
}

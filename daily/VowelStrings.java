import java.util.HashMap;
import java.util.Map;

/**
 * 2586. 统计范围内的元音字符串数
 * https://leetcode.cn/problems/count-the-number-of-vowel-strings-in-range/description/
 */
public class VowelStrings {

	private Map<Character, Integer> cm = new HashMap<>(5);

	public int vowelStrings(String[] words, int left, int right) {
		cm.put('a', 1);
		cm.put('e', 1);
		cm.put('i', 1);
		cm.put('o', 1);
		cm.put('u', 1);
		int sum = 0;
		for (int i = left; i <= right; i++) {
			sum+=isVowel(words[i]);
		}
		return sum;
	}

	private int isVowel(String word) {
		return (cm.getOrDefault(word.charAt(0), 0) + cm.getOrDefault(word.charAt(word.length()-1), 0))/2;
	}

	public static void main(String[] args) {
		VowelStrings vowelStrings = new VowelStrings();
		String[] words = {"are","amy","u"};
		int i = vowelStrings.vowelStrings(words, 0, 2);
		System.out.println(i);
	}
}

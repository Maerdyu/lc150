/**
 * 242. 有效的字母异位词
 * https://leetcode.cn/problems/valid-anagram/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsAnagram {

	public boolean isAnagram(String s, String t) {
		char[] sc = s.toCharArray();
		char[] tc = t.toCharArray();
		if(sc.length != tc.length){
			return false;
		}
		int[] sa = new int[26];
		for (char c : sc) {
			sa[c - 'a']++;
		}
		for (char c : tc) {
			sa[c - 'a']--;
			if(sa[c - 'a'] < 0){
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		IsAnagram isAnagram = new IsAnagram();
		boolean a1 = isAnagram.isAnagram("rat", "cat");
		boolean a2 = isAnagram.isAnagram("anagram", "nagaram");
		System.out.println(a1 + " " + a2);
	}
}

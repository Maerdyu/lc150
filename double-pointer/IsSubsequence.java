/**
 * 392. 判断子序列
 * https://leetcode.cn/problems/is-subsequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class IsSubsequence {
	public boolean isSubsequence(String s, String t) {
		int sn = s.length();
		int tn = t.length();
		if (sn > tn) {
			return false;
		}
		int i = 0, j = 0;
		while (i < sn && j < tn) {
			if (s.charAt(i) == t.charAt(j)) {
				i++;
			}
			j++;
		}
		return i == sn;
	}

	// 动态规划

	public static void main(String[] args) {
		IsSubsequence isSubsequence = new IsSubsequence();
		boolean subsequence = isSubsequence.isSubsequence("abc", "ahbgdc");
		System.out.println(subsequence);
	}
}

import java.util.HashMap;
import java.util.Map;

/**
 * 76. 最小覆盖子串
 * https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinWindow {
	public String minWindow(String s, String t) {
		char[] tcs = t.toCharArray();
		char[] scs = s.toCharArray();
		Map<Character, Integer> tm = new HashMap<>();
		for (char tc : tcs) {
			tm.put(tc, tm.getOrDefault(tc, 0) + 1);
		}

		Map<Character, Integer> sm = new HashMap<>();
		int start = 0, end = 0, minLength = s.length()+1, cnt = 0;
		String res = "";
		while (end < s.length()) {
			if (tm.containsKey(scs[end])) {
				Integer sct = sm.getOrDefault(scs[end], 0);
				if (sct < tm.get(scs[end])) {
					cnt++;
				}
				sm.put(scs[end], sct + 1);
			}

			while (cnt >= t.length()) {
				if ((end - start + 1) < minLength) {
					minLength = end - start + 1;
					res = s.substring(start, end + 1);
				}
				if (tm.containsKey(scs[start])) {
					Integer sst = sm.get(scs[start]);
					if (sst <= tm.get(scs[start])) {
						cnt--;
					}
					sm.put(scs[start], sst - 1);
				}
				start++;

			}
			end++;
		}
		return res;
	}

	public static void main(String[] args) {
		MinWindow minWindow = new MinWindow();
		String s = minWindow.minWindow("a", "a");
		System.out.println(s);
	}
}

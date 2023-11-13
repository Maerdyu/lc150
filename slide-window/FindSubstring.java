import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 30. 串联所有单词的子串
 * https://leetcode.cn/problems/substring-with-concatenation-of-all-words/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class FindSubstring {
	public List<Integer> findSubstring(String s, String[] words) {
		int wl = words[0].length();
		Map<String, Integer> wm = new HashMap<>();
		for (String word : words) {
			wm.put(word, wm.getOrDefault(word, 0) + 1);
		}

		List<Integer> res = new ArrayList<>();
		Map<String, Integer> sm = new HashMap<>();
		for (int i = 0; i < wl; i++) {
			sm.clear();
			int start = i, end = i, sEnd = (s.length() - i) / wl * wl, cnt = 0;
			while (end < sEnd) {
				String sw = s.substring(end, end + wl);
				if (wm.containsKey(sw)) {
					Integer sst = sm.getOrDefault(sw, 0);
					if (sst < wm.get(sw)) {
						cnt++;
						sm.put(sw, sst + 1);
						if (cnt == words.length) {
							res.add(start);

							String fw = s.substring(start, start + wl);
							sm.put(fw, sm.get(fw) - 1);
							start += wl;
							cnt--;
						}
						end += wl;
					}
					else {
						String fw = "";
						do {
							fw = s.substring(start, start + wl);
							sm.put(fw, sm.get(fw) - 1);
							cnt--;
							start += wl;
						}
						while (!fw.equals(sw));
					}
				}
				else {
					sm.clear();
					cnt = 0;
					end += wl;
					start = end;
				}

			}
		}
		return res;
	}

	public static void main(String[] args) {
		FindSubstring findSubstring = new FindSubstring();
		String[] words = {"aa", "aa"};
		List<Integer> barfoothefoobarman = findSubstring.findSubstring("aaaaaaaaaaaaaa", words);
		for (Integer integer : barfoothefoobarman) {
			System.out.println(integer);
		}
	}
}

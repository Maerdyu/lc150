import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 49. 字母异位词分组
 * https://leetcode.cn/problems/group-anagrams/?envType=study-plan-v2&envId=top-interview-150
 */
public class GroupAnagrams {
	public List<List<String>> groupAnagrams(String[] strs) {
		Map<String, List<String>> res = new HashMap<>();
		for (String str : strs) {
			char[] chars = str.toCharArray();
			Arrays.sort(chars);
			String key = String.valueOf(chars);
			List<String> list = res.getOrDefault(key, new ArrayList<>());
			list.add(str);
			res.put(key, list);
		}
		List<List<String>> resList = new ArrayList<>();
		res.forEach((k,v)-> resList.add(v));
		return resList;
	}

	public static void main(String[] args) {
		GroupAnagrams groupAnagrams = new GroupAnagrams();
		String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
		List<List<String>> lists = groupAnagrams.groupAnagrams(strs);
		for (List<String> list : lists) {
			for (String s : list) {
				System.out.print(s + " ");
			}
			System.out.println("\n");
		}
	}
}

import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		final Integer[] max = {0};
		Map<Integer, Integer> icm = new HashMap<>();
		for (int num : nums) {
			Integer lc = icm.getOrDefault(num - 1, 0);
			Integer rc = icm.getOrDefault(num + 1, 0);
			for (int j = 1; j <= lc; j++) {
				icm.put(num - j, icm.get(num - j) + 1 + rc);
			}

			for (int j = 1; j <= rc; j++) {
				icm.put(num + j, icm.get(num + j) + 1 + lc);
			}
			int lmx = Math.max(lc + 1, rc + 1);
			icm.put(num, lmx);
		}
		icm.forEach((k,v)->{
			if(max[0] < v){
				max[0] = v;
			}
		});
		return max[0];
	}

	public static void main(String[] args) {
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		int[] nums = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
		int i = longestConsecutive.longestConsecutive(nums);
		System.out.println(i);
	}
}

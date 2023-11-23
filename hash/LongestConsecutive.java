import java.util.HashMap;
import java.util.Map;

/**
 * 128. 最长连续序列
 * https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class LongestConsecutive {
	public int longestConsecutive(int[] nums) {
		int max = 0;
		Map<Integer, Integer> icm = new HashMap<>();
		for (int num : nums) {
			if(icm.containsKey(num)){
				continue;
			}

			Integer lc = icm.getOrDefault(num - 1, 0);
			Integer rc = icm.getOrDefault(num + 1, 0);
			int temp = rc + 1 + lc;
			icm.put(num, -1);
			icm.put(num - lc, temp);
			icm.put(num + rc, temp);
			max = Math.max(max, temp);
		}
		return max;
	}

	public static void main(String[] args) {
		LongestConsecutive longestConsecutive = new LongestConsecutive();
		int[] nums = {4,0,-4,-2,2,5,2,0,-8,-8,-8,-8,-1,7,4,5,5,-4,6,6,-3};
		int i = longestConsecutive.longestConsecutive(nums);
		System.out.println(i);
	}
}

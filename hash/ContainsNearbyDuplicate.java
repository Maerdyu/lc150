import java.util.HashMap;
import java.util.Map;

/**
 * 219. 存在重复元素 II
 * https://leetcode.cn/problems/contains-duplicate-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ContainsNearbyDuplicate {
	public boolean containsNearbyDuplicate(int[] nums, int k) {
		Map<Integer, Integer> nm = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (!nm.containsKey(nums[i])) {
				nm.put(nums[i], i);
			}
			else {
				Integer integer = nm.get(nums[i]);
				if (i - integer <= k) {
					return true;
				}
				else {
					nm.put(nums[i], i);
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContainsNearbyDuplicate containsNearbyDuplicate = new ContainsNearbyDuplicate();
		int[] nums = {1,2,3,1,2,3};
		boolean b = containsNearbyDuplicate.containsNearbyDuplicate(nums, 2);
		System.out.println(b);
	}
}

/**
 * 209. 长度最小的子数组
 * https://leetcode.cn/problems/minimum-size-subarray-sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MinSubArrayLen {

	public int minSubArrayLen(int target, int[] nums) {
		int n = nums.length;
		int res = n, start = 0, end = 0, sum = 0;

		while (end < n) {
			sum += nums[end];
			if (sum >= target) {
				while (sum >= target) {
					res = Math.min(end - start + 1, res);
					sum -= nums[start++];
				}
			}
			end++;
		}
		return res ;
	}

	public static void main(String[] args) {
		MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
		int[] nums = {1,2,3,4,5};
		int i = minSubArrayLen.minSubArrayLen(15, nums);
		System.out.println(i);
	}
}

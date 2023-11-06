/**
 * 42. 接雨水
 * https://leetcode.cn/problems/trapping-rain-water/description/
 */
public class CatchRainwater {

	/**
	 * 双指针
	 * @param height 柱子高度
	 * @return 雨水的总量
	 */
	public int trap(int[] height) {
		int n = height.length;
		int start = 0, end = n - 1, sum = 0, left = height[0], right = height[n - 1];
		while (start < end) {
			if (left >= right) {
				if (right - height[end - 1] >= 0) {
					sum += right - height[end - 1];
				}
				else {
					right = height[end - 1];
				}
				end--;
			}
			else {
				if (left - height[start + 1] >= 0) {
					sum += left - height[start + 1];
				}
				else {
					left = height[start + 1];
				}
				start++;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		CatchRainwater catchRainwater = new CatchRainwater();
		int[] height = {4,2,0,3,2,5};
		int trap = catchRainwater.trap(height);
		System.out.println(trap);
	}
}

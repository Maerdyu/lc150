/**
 * 11. 盛最多水的容器
 * https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class MaxArea {

	// TODO 找到一个比当前值大的
	public int maxArea(int[] height) {
		int start = 0, end = height.length-1, sum = 0;
		while (start < end){
			if(height[start] > height[end]){
				sum = Math.max(sum, (end-start)*height[end]);
				end--;
			}else if(height[start] < height[end]){
				sum = Math.max(sum, (end-start)*height[start]);
				start++;
			}else {
				sum = Math.max(sum, (end-start)*height[start]);
				start++;
				end--;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		MaxArea maxArea = new MaxArea();
		int[] height = {1,8,6,2,5,4,8,3,7};
		int i = maxArea.maxArea(height);
		System.out.println(i);
	}
}

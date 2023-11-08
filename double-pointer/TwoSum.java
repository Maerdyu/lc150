/**
 * 167. 两数之和 II - 输入有序数组
 * https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class TwoSum {

	public int[] twoSum(int[] numbers, int target) {
		int n = numbers.length;
		int start = 0, end = n - 1;
		while (start < end) {
			if (numbers[start] + numbers[end] > target) {
				end--;
			}
			else if (numbers[start] + numbers[end] < target) {
				start++;
			}
			else {
				return new int[] {start + 1, end + 1};
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] numbers = {2,7,11,15};
		int[] ints = twoSum.twoSum(numbers, 9);
		for (int anInt : ints) {
			System.out.println(anInt);
		}
	}
}

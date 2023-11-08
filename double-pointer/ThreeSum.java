import java.util.ArrayList;
import java.util.List;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ThreeSum {
	// 排序, 去重，双指针
	public List<List<Integer>> threeSum(int[] nums) {
		// 快速排序
		quickSort(nums, 0, nums.length - 1);
		for (int num : nums) {
			System.out.println(num);
		}

		List<List<Integer>> res = new ArrayList<>();
		return res;
	}

	public void quickSort(int[] nums, int i, int j) {
		if (i >= j) {
			return;
		}
		int split = merge(nums, i, j);
		quickSort(nums, i, split - 1);
		quickSort(nums, split + 1, j);
	}

	private int merge(int[] nums, int i, int j) {
		int compare = nums[j];
		int n = i, m = i;
		while (m < j) {
			if (nums[m] < compare) {
				swap(nums, n++, m++);
			}
			else {
				m++;
			}
		}
		swap(nums, n, j);
		return n;
	}

	private void swap(int[] nums, int i, int j) {
		if (i == j) {
			return;
		}
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		ThreeSum threeSum = new ThreeSum();
		int[] nums = {-1, 0, 1, 2, -1, -4};
		List<List<Integer>> lists = threeSum.threeSum(nums);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println("\n");
		}
	}
}

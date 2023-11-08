import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

/**
 * 15. 三数之和
 * https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class ThreeSum {
	// 排序, 去重，双指针
	public List<List<Integer>> threeSum(int[] nums) {
		// 快速排序
		quickSort(nums, 0, nums.length - 1);

		List<List<Integer>> res = new ArrayList<>();

		for (int i = 0; i < nums.length - 2; i++) {
			if (i > 0 && nums[i] == nums[i - 1])
				continue;
			int start = i + 1, end = nums.length - 1;
			while (start < end) {
				int sum = nums[i] + nums[start] + nums[end];
				if(sum == 0){
					res.add(Arrays.asList(nums[i], nums[start], nums[end]));
				}
				// 减小
				if (sum >= 0) {
					do {
						end--;
					} while (start < end && nums[end] == nums[end + 1]);

				} else if (sum <= 0) {
					do{
						start++;
					}while(start < end && nums[start] == nums[start-1]);
				}
			}
		}

		
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
			// 如果m的值比compare小，就挪到i的位置（i为第一个大于compare的位置）
			if (nums[m] < compare) {
				swap(nums, n++, m++);
			} else {
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
		int[] nums = {0,0,0,0};
		List<List<Integer>> lists = threeSum.threeSum(nums);
		for (List<Integer> list : lists) {
			for (Integer integer : list) {
				System.out.print(integer);
			}
			System.out.println("\n");
		}
	}
}

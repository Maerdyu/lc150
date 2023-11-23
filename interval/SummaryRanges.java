import java.util.ArrayList;
import java.util.List;

public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if (nums == null || nums.length == 0) {
			return res;
		}
		if (nums.length == 1) {
			res.add(String.valueOf(nums[0]));
			return res;
		}

		int start = nums[0], index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] - 1 != nums[i - 1]) {
				int step = i - index;
				if (1 == step){
					res.add(String.valueOf(start));
				}else {
					res.add(String.format("%d->%d", start, nums[i-1]));
				}
				start = nums[i];
				index = i;
			}
		}

		int step = nums.length -1 - index;
		if (1 == step){
			res.add(String.valueOf(start));
		}else {
			res.add(String.format("%d->%d", start, nums[nums.length-1]));
		}

		return res;
	}

	public static void main(String[] args) {
		SummaryRanges summaryRanges = new SummaryRanges();
		int[] nums = {0, 1, 2, 4, 5, 7};
		List<String> strings = summaryRanges.summaryRanges(nums);
		for (String string : strings) {
			System.out.println(string);
		}
	}
}

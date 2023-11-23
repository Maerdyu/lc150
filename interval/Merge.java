import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge {

	public int[][] merge(int[][] intervals) {
		List<int[]> res = new ArrayList<>();
		if (intervals.length <= 1) {
			return intervals;
		}

		Arrays.sort(intervals, Comparator.comparingInt(x -> x[0]));
		int[] temp = intervals[0];
		for (int i = 0; i < intervals.length; i++) {
			if (intervals[i][0] <= temp[1]) {
				temp[1] = Math.max(intervals[i][1], temp[1]);
			}
			else {
				res.add(temp);
				temp = intervals[i];
			}
		}
		res.add(temp);
		int[][] result = new int[res.size()][2];
		return res.toArray(result);
	}

	public static void main(String[] args) {
		Merge merge = new Merge();
		int[][] intervals = {{1,4}, {4,5}};
		int[][] merge1 = merge.merge(intervals);
		for (int[] ints : merge1) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println("\n");
		}

	}
}

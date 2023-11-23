import java.util.Arrays;
import java.util.Comparator;

public class FindMinArrowShots {
	public int findMinArrowShots(int[][] points) {
		if (points.length == 0) {
			return 0;
		}
		Arrays.sort(points, Comparator.comparingInt(x -> x[0]));
		int[] dup = points[0];
		int cnt = 1;
		for (int i = 1; i < points.length; i++) {
			if (points[i][0] > dup[1]) {
				cnt++;
				dup = points[i];
			}
			else if (points[i][0] <= dup[1]) {
				dup[0] = points[i][0];
				dup[1] = Math.min(points[i][1], dup[1]);
			}
			else {
				cnt++;
				dup[0] = points[i - 1][1];
				dup[1] = points[i][0];
			}
		}
		return cnt;
	}


	public static void main(String[] args) {
		FindMinArrowShots findMinArrowShots = new FindMinArrowShots();
		int[][] point = {{3, 9}, {7, 12}, {3, 8}, {6, 8}, {9, 10}, {2, 9}, {0, 9}, {3, 9}, {0, 6}, {2, 8}};
		int minArrowShots = findMinArrowShots.findMinArrowShots(point);
		System.out.println(minArrowShots);
	}
}

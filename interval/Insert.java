import java.util.ArrayList;

public class Insert {

	public int[][] insert(int[][] intervals, int[] newInterval) {

		int length = intervals.length;
		if(length < 1){
			return new int[][] {newInterval};
		}

		ArrayList<int[]> res = new ArrayList<>();
		boolean done = false;
		for (int i = 0; i < length; i++) {
			if (done) {
				res.add(intervals[i]);
				continue;
			}

			if (intervals[i][0] > newInterval[1]) {
				res.add(newInterval);
				res.add(intervals[i]);
				done = true;
			}
			else {
				if (intervals[i][1] < newInterval[0]) {
					res.add(intervals[i]);
				}
				else {
					int min = Math.min(intervals[i][0], newInterval[0]);
					int max = newInterval[1];
					while (i< length && max >= intervals[i][0]){
						max = Math.max(max, intervals[i][1]);
						i++;
					}
					i--;
					int[] merge = {min, max};
					res.add(merge);
					done = true;
				}
			}
		}
		if(!done){
			res.add(newInterval);
		}

		return res.toArray(new int[res.size()][]);
	}

	public static void main(String[] args) {
		Insert insert = new Insert();
		int[][] a = {{1,3}};
		int[] target = {0,0};
		int[][] insert1 = insert.insert(a, target);
		for (int[] ints : insert1) {
			for (int anInt : ints) {
				System.out.print(anInt + " ");
			}
			System.out.println("\n");
		}
	}
}

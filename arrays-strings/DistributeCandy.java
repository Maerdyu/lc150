/**
 * 135. 分发糖果
 * https://leetcode.cn/problems/candy/description/
 */
public class DistributeCandy {

	/**
	 * 两次贪心，左右各一次
	 * @param ratings 每个小孩的得分
	 * @return 最小糖果数量
	 */
	public int candy(int[] ratings) {
		int n = ratings.length;
		int[] res = new int[n];
		res[0] = 1;
		for (int i = 1; i < n; i++) {
			if (ratings[i] > ratings[i - 1]) {
				res[i] = res[i - 1] + 1;
			}else {
				res[i] = 1;
			}
		}
		for (int i = n - 2; i >= 0; i--) {
			if (ratings[i] > ratings[i + 1]) {
				res[i] = Math.max(res[i + 1] + 1, res[i]);
			}
		}

		int sum = 0;
		for (int re : res) {
			sum += re;
		}
		return sum;
	}

	public static void main(String[] args) {
		DistributeCandy distributeCandy = new DistributeCandy();
		int[] ratings = {1,3,4,5,2};
		// 1,2,3,4,1
		int candy = distributeCandy.candy(ratings);
		System.out.println(candy);
	}
}

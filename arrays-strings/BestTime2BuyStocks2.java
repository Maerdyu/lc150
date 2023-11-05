
/**
 * 122. 买卖股票的最佳时机 II
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150
 */
public class BestTime2BuyStocks2 {

    /**
     * 贪心：只要计算涨的时候差值和
     * 
     * @param prices 每天的价格
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }

    /**
     * 动态规划:d[i][j],i表示第i天，j表示持有股票或者不持有
     * d[i][0] 表示第i天不持有股票的最大收益 d[i][1] 表示第i天持有股票
     * 初始值: d[0][0] = 0 d[0][1]=-prices[0](买入，收益为负)
     * 转移方程：d[i][0] = max(d[i-1][0], d[i-1][1]+price[i]) d[i][1] =
     * max(d[i-1][0]-price[i], d[i-1][1])
     * 由于最后一天不持有股票时有最大收益，结果返回d[length-1][0]
     * 
     * @param prices 每天的价格
     * @return 最大收益
     */
    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if (n < 2) {
            return 0;
        }
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }
        return dp[n - 1][0];
    }

    public static void main(String[] args) {
        BestTime2BuyStocks2 bestTime2BuyStocks2 = new BestTime2BuyStocks2();
        int[] prices = { 7, 1, 5, 3, 6, 4 };
        int maxProfit = bestTime2BuyStocks2.maxProfit(prices);
        System.out.println(maxProfit);
    }
}

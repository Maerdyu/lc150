
/**
 * 121. 买卖股票的最佳时机
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/?envType=study-plan-v2&envId=top-interview-150
 * 
 */
public class BestTime2BuyStocks{

    /**
     * 通过维护一个截至当前时间的最小价格，计算每日的最大收益
     * @param prices 每日的股票价格
     * @return 最大收益
     */
    public int maxProfit(int[] prices) {
        int lowPrice = prices[0], profit=0;
        for (int p = 1; p < prices.length; p++) {
            if(lowPrice > prices[p]){
                lowPrice = prices[p];
            }else {
                profit = Math.max(prices[p]-lowPrice, profit);
            }
        }
        return profit;
    }

    public static void main(String[] args) {
        BestTime2BuyStocks bestTime2BuyStocks = new BestTime2BuyStocks();
        int[] prices = {7,1,5,3,6,4};
        int maxProfit = bestTime2BuyStocks.maxProfit(prices);
        System.out.println(maxProfit);
    }
}
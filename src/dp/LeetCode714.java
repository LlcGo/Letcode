package dp;

/**
 * @Author Lc
 * @Date 2023/9/11
 * @PackageName: dp
 * @ClassName: LeetCode714
 * @Description: 买卖股票最佳时机 含手续费
 */

public class LeetCode714 {
    public int maxProfit(int[] prices, int fee) {
        //dp 数组
        int len = prices.length;
        if(len == 0){
            return 0;
        }
        //持有股票
        int[][] dp = new int[len][2];
        dp[0][0] = -prices[0];
        //不持有股票
        dp[0][1]= 0;
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i - 1][1] - prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i - 1][0]+prices[i]-fee);
        }
        return dp[len-1][1];
    }
}

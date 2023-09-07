package dp;

/**
 * @Author Lc
 * @Date 2023/9/7
 * @PackageName: dp
 * @ClassName: LeetCode122
 * @Description: 买卖股票最佳时机Ⅱ
 */

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        //dp数组状态 二维数组表示
        int len =  prices.length;
        //dp[len][0]代表不持有股票
        //dp[len][1]代表持有股票
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i = 1; i < len; i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0] - prices[i]);
        }
        return dp[len-1][0];
    }
}

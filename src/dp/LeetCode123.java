package dp;

/**
 * @Author Lc
 * @Date 2023/9/8
 * @PackageName: dp
 * @ClassName: LeetCode123
 * @Description: 买卖股票最佳时机
 */

public class LeetCode123 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len == 0) return 0;
        //定义dp数组
        int [][] dp = new int [len][5];
        //初始化
        //第一次持有
        dp[0][1]  = -prices[0];
        //第一次不持有 当天买卖
        dp[0][2]  = 0;
        //第二次持有
        dp[0][3]  = -prices[0];
        //第二次不持有
        dp[0][4] = 0;
        for(int i = 1; i < len; i++){
            dp[i][1] = Math.max(dp[i - 1][1], -prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        return dp[len - 1][4];
    }
}

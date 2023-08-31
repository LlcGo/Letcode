package dp;

/**
 * @Author Lc
 * @Date 2023/8/31
 * @PackageName: dp
 * @ClassName: LeetCode279
 * @Description: 完全平方数
 */

public class LeetCode279 {
    public int numSquares(int n) {
        int max = Integer.MAX_VALUE;
        int[] dp = new int[n + 1];
        //初始化
        for (int j = 0; j <= n; j++) {
            dp[j] = max;
        }
        //如果不想要寫for-loop填充數組的話，也可以用JAVA內建的Arrays.fill()函數。
        //Arrays.fill(dp, Integer.MAX_VALUE);

        //当和为0时，组合的个数为0
        dp[0] = 0;
        // 遍历物品
        for (int i = 1; i * i <= n; i++) {
            // 遍历背包
            for (int j = i * i; j <= n; j++) {
                //if (dp[j - i * i] != max) {
                dp[j] = Math.min(dp[j], dp[j - i * i] + 1);
                //}
                //不需要這個if statement，因爲在完全平方數這一題不會有"湊不成"的狀況發生（ 一定可以用    "1"     來組成任何一個n），故comment掉這個if statement。
            }
        }
        return dp[n];
    }
}

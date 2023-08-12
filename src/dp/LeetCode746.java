package dp;

/**
 * @Author Lc
 * @Date 2023/8/12
 * @PackageName: dp
 * @ClassName: LeetCode746
 * @Description: 使用最小花费爬楼梯
 */

public class LeetCode746 {
    public int minCostClimbingStairs(int[] cost) {
        //dp 为没到一次台阶所花费的费用
        //因为还有最后一层楼梯所以+1
        int [] dp = new int[cost.length + 1];
        //一开始在第一个台阶的花费
        dp[0] = 0;
        //一开始在第二个台阶时候的花费
        dp[1] = 0;
        for(int i = 2; i <= cost.length ; i++){
            //每次到下一个台阶的花费，之前的加上现在的；
            dp[i] = Math.min(dp[i-1] + cost[i-1],dp[i-2]+cost[i-2]);
        }
        return dp[cost.length];
    }
}

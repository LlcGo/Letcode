package dp;

/**
 * @Author Lc
 * @Date 2023/8/10
 * @PackageName: cupidity
 * @ClassName: LeetCode509
 * @Description: 斐波那契数列
 */

public class LeetCode509 {
    public int fib(int n) {
        if(n < 2){
            return n;
        }
        //因为如果是3的话证明有4个数组dp0为0 dp1为1 dp2为1
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
}

package dp;

/**
 * @Author Lc
 * @Date 2023/8/11
 * @PackageName: dp
 * @ClassName: LeetCode70
 * @Description: 爬楼梯
 */

public class LeetCode70 {
    public int climbStairs(int n) {
        if( n <= 1){
            return n;
        }
        int dp[] = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

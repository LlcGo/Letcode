package dp;

/**
 * @Author Lc
 * @Date 2023/8/29
 * @PackageName: dp
 * @ClassName: LeetCode70dp
 * @Description:
 */

public class LeetCode70dp {
    public int climbStairs(int n) {
    //到i层有dp[i]个方法
    int [] dp = new int[n + 1];
    int m = 2; //控制每次走一个台阶；后者走俩个台阶；
    dp[0] = 1; //不能初始化0；不然永远都是0
    for(int i = 1; i <= n; i++){
        for(int j = 1; j <= m; j++){
            if (i >= j){
                dp[i] += dp[i-j];
            }
        }
    }
    return dp[n];
}
}

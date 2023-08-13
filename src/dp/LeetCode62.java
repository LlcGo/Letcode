package dp;

/**
 * @Author Lc
 * @Date 2023/8/13
 * @PackageName: dp
 * @ClassName: LeetCode62
 * @Description: 不同路径
 */

public class LeetCode62 {
    public int uniquePaths(int m, int n) {
        //dp[i][j] 代表走到最终位置有多少种路径
        //dp[i-1][j]
        //dp[i][j-1]
        //dp[i-1][j]+dp[i][j-1]
        //dp初始化
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}

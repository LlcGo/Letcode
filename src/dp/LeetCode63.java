package dp;

/**
 * @Author Lc
 * @Date 2023/8/15
 * @PackageName: dp
 * @ClassName: LeetCode63
 * @Description: 不同路径Ⅱ
 */

public class LeetCode63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //dp[i][j]到达目的地有多少种不同的路径
        //如果其实状态有障碍，或者目的地址有障碍直接没有办法走
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int [][] dp = new int[m][n];

        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }

        for(int i = 0; i < m && obstacleGrid[i][0] == 0; i++){
            dp[i][0] = 1;
        }
        for(int j = 0; j < n && obstacleGrid[0][j] == 0; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i< m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j]= (obstacleGrid[i][j] == 0) ? dp[i-1][j]+ dp[i][j-1] : 0;
            }
        }
        return dp[m-1][n-1];
    }
}

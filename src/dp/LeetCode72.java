package dp;

/**
 * @Author Lc
 * @Date 2023/9/28
 * @PackageName: dp
 * @ClassName: LeetCode72
 * @Description: 编辑距离
 */

public class LeetCode72 {
    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        int [][] dp = new int[len1 + 1][len2 + 1];

        // 初始化
        for (int i = 1; i <= len1; i++) {
            dp[i][0] =  i;
        }
        for (int j = 1; j <= len2; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 因为dp数组有效位从1开始
                // 所以当前遍历到的字符串的位置为i-1 | j-1
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }
        return dp[len1][len2];

    }
}

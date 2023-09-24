package dp;

/**
 * @Author Lc
 * @Date 2023/9/24
 * @PackageName: dp
 * @ClassName: LeetCode97
 * @Description: 不同的子序列
 */

public class LeetCode97 {
    public int numDistinct(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        //已i-1结尾的S中有已j-1为结尾的t的个数
        int [][] dp = new int[len1+1][len2+1];
        for (int i = 0; i < s.length() + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s.charAt(i - 1) == t.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[len1][len2];
    }
}

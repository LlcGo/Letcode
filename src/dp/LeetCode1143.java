package dp;

/**
 * @Author Lc
 * @Date 2023/9/18
 * @PackageName: dp
 * @ClassName: LeetCode1143
 * @Description:
 */

public class LeetCode1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        char [] char1 = text1.toCharArray();
        char [] char2 = text2.toCharArray();
        //初始化dp
        int [][] dp = new int[char1.length + 1][char2.length + 1];
        for(int i = 1; i <= char1.length; i++){
            for(int j = 1; j <= char2.length; j++){
                //如果子序列相等
                if(char1[i-1] == char2[j-1]){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}

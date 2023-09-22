package dp;

/**
 * @Author Lc
 * @Date 2023/9/22
 * @PackageName: dp
 * @ClassName: LeetCode392
 * @Description: 判断子序列
 */

public class LeetCode392 {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();
        int [][] dp = new int[len1 + 1][len2 + 1];

        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = dp[i][j-1];
                }
            }
        }
        if(dp[len1][len2] == len1){
            return true;
        }else{
            return false;
        }
    }
}

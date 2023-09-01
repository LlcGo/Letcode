package dp;

import java.util.HashSet;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/9/1
 * @PackageName: dp
 * @ClassName: LeetCode139
 * @Description: 139. 单词拆分
 */

public class LeetCode139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i && !dp[i] ; j++){
                if(set.contains(s.substring(j, i)) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
}

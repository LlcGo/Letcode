package dp;

/**
 * @Author Lc
 * @Date 2023/8/28
 * @PackageName: dp
 * @ClassName: LeetCode377
 * @Description: 组合问题Ⅳ
 */

public class LeetCode377 {
    public int combinationSum4(int[] nums, int target) {
        int [] dp = new int [target + 1];
        dp[0] = 1;
        for(int i = 0; i <= target; i++){
            for(int j = 0; j < nums.length; j++){
                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }
        return dp[target];
    }
}

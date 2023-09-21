package dp;

/**
 * @Author Lc
 * @Date 2023/9/21
 * @PackageName: dp
 * @ClassName: LeetCode53
 * @Description: 最大子数组和
 */

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int res = nums[0];
        int[] dp = new int [len];
        dp[0] = nums[0];
        for(int i = 1; i < len; i++){
            dp[i] = Math.max(dp[i-1] + nums[i],nums[i]);
            res = res > dp[i] ? res : dp[i];
        }
        return res;
    }
}

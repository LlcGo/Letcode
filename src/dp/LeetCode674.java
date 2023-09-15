package dp;

/**
 * @Author Lc
 * @Date 2023/9/15
 * @PackageName: dp
 * @ClassName: LeetCode674
 * @Description: 最长连续递增序列
 */

public class LeetCode674 {
    public int findLengthOfLCIS(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return 1;
        }
        //已i为下标的最长子序列长度
        int []dp = new int[len];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int result = 1;
        for(int i = 1; i < len; i++){
            if(nums[i] > nums[i-1]){
                dp[i] = dp[i-1]+1;
            }
            if (dp[i] > result) result = dp[i];
        }
        return result;
    }
}

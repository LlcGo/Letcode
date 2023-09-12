package dp;

import java.util.Arrays;

/**
 * @Author Lc
 * @Date 2023/9/12
 * @PackageName: dp
 * @ClassName: LeetCode300
 * @Description: 最长递增子序列
 */

public class LeetCode300 {
    public int lengthOfLIS(int[] nums) {
        int [] dp = new int [nums.length];
        int res = 0;
        //初始化全部填充为1
        Arrays.fill(dp, 1);
        for(int i = 1; i < dp.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
                res = Math.max(res,dp[i]);
            }
        }
        return res;
    }
}

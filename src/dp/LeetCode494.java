package dp;

/**
 * @Author Lc
 * @Date 2023/8/27
 * @PackageName: dp
 * @ClassName: LeetCode494
 * @Description: 目标和
 */

public class LeetCode494 {
    static int [] nums = new int[]{1,1,1,1,1};
    static int target = 3;
    public static void main(String[] args) {
        int targetSumWays = findTargetSumWays(nums, target);
        System.out.println(targetSumWays);
    }

    public static int findTargetSumWays(int[] nums, int target) {
        //装满dp[j] 这个背包j 有dp[j]种方法
        int sum = 0;
        for(int num : nums){
            //所有的数
            sum += num;
        }
        //如果target过大 sum将无法满足
        if(target < 0 && sum <-target) {
            return 0;
        }
        if((target + sum)%2 != 0){
            return 0;
        }
        int size = (target + sum) / 2;
        if(size < 0) {
            size = -size;
        }
        int[] dp = new int[size + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            System.out.println(" num[i] ->" + nums[i]);
            for (int j = size; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
                System.out.println("dp[j] ->"+ dp[j]);
            }
        }
        return dp[size];
    }
}

package dp;

/**
 * @Author Lc
 * @Date 2023/8/22
 * @PackageName: dp
 * @ClassName: LeetCode1049
 * @Description: 最后一块石头的重量II
 */

public class LeetCode1049 {
        public int lastStoneWeightII(int[] stones) {
            //需要把这个石头的数量分为俩堆，然后尽量组成其中的一堆
            int sum = 0;
            for(int i : stones){
                sum += i;
            }
            int target = sum / 2;
            //初始化dp数组
            int[] dp = new int[target + 1];
            for(int i = 0; i < stones.length; i++){
                for(int j = target; j>= stones[i]; j--){
                    dp[j] = Math.max(dp[j],dp[j-stones[i]] + stones[i]);
                }
            }
            return sum-dp[target]-dp[target];
        }
}

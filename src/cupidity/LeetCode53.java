package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/24
 * @PackageName: cupidity
 * @ClassName: LeetCode53
 * @Description: 最大子数组和
 */

public class LeetCode53 {
    public int maxSubArray(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int result = Integer.MIN_VALUE;
        int current = 0;
        for(int i = 0; i < nums.length; i++){
            current += nums[i];
            if(result < current){
                result = current;
            }
            if(current < 0){
                current = 0;
            }
        }
        return result;
    }
}

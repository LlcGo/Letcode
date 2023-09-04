package dp;

/**
 * @Author Lc
 * @Date 2023/9/4
 * @PackageName: dp
 * @ClassName: LeetCode213
 * @Description: 打家劫舍Ⅱ
 */

public class LeetCode213 {
    public int rob(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(rebot(nums,1,nums.length),rebot(nums,0,nums.length-1));
    }

    public int rebot(int [] nums,int start, int end){
        int x = 0, y = 0, z = 0;
        for (int i = start; i < end; i++) {
            y = z;
            z = Math.max(y, x + nums[i]);
            x = y;
        }
        return z;
    }
}

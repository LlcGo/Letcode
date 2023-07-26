package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/26
 * @PackageName: cupidity
 * @ClassName: LeetCode55
 * @Description: 跳跃游戏
 */

public class LeetCode55 {

    public boolean canJump(int[] nums) {
        if(nums.length == 1){
            return true;
        }
        //覆盖范围
        int cover = 0;
        //只能再覆盖范围内进行选择
        for(int i = 0; i<=cover;i++){
            //每次前进覆盖范围都会有变化,选择最大的
            cover = Math.max(i + nums[i],cover);
            if(cover >= nums.length-1){
                return true;
            }
        }
        return false;
    }
}

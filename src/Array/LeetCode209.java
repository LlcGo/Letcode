package Array;

/**
 * @Author Lc
 * @Date 2023/10/8
 * @PackageName: Array
 * @ClassName: LeetCode209
 * @Description: 209. 长度最小的子数组
 */

public class LeetCode209 {
    public int minSubArrayLen(int target, int[] nums) {
        //滑动窗口，思想
        //一个指针负责统计值，每个值相加，加到最后大于等于target，然后就停止
        //另一个指针在这个终止的范围内取值找到最小的结果返回
        int i = 0; //开始位置
        int j = 0; //终止位置
        int num = 0;
        int result = Integer.MAX_VALUE;
        for(; j < nums.length; j++){
            //每次都累加
            num += nums[j];
            while(num >= target){
                result = Math.min(result,j-i+1);
                num -= nums[i++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}

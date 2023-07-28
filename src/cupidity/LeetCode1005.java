package cupidity;

import java.util.stream.IntStream;

/**
 * @Author Lc
 * @Date 2023/7/28
 * @PackageName: cupidity
 * @ClassName: LeetCode1005
 * @Description: K 次取反后最大化的数组和
 */

public class LeetCode1005 {
    public int largestSumAfterKNegations(int[] nums, int k) {
        nums = IntStream.of(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue).toArray();
        for(int i = 0; i < nums.length; i++){
            //如果当前的数是负数我们就取反
            //第一次取反
            if(nums[i] < 0 && k > 0){
                nums[i] *= -1;
                k--;
            }
        }
        //如果是奇数那我们就需要取反一次就就可以，偶数不用取反，取反几次都是原来的数
        if(k % 2 == 1){
            nums[nums.length-1] *= -1;
        }
        int result =0;
        for(int i =0; i< nums.length; i++){
            result += nums[i];
        }
        return result;

    }
}

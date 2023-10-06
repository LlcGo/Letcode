package Array;

/**
 * @Author Lc
 * @Date 2023/10/6
 * @PackageName: Array
 * @ClassName: LeetCode997
 * @Description: 977.有序数组的平方
 */

public class LeetCode977 {
    public int[] sortedSquares(int[] nums) {
        //最大的数字一定在俩边 平方之后
        int left = 0;
        int right = nums.length - 1;
        //所以只要算到中间的时候就不用换了 左右比较最大的放到最右边
        int[] res = new int[nums.length];
        int len = nums.length - 1;
        while(left <= right){
            if(nums[left] * nums[left] > nums[right] * nums[right]){
                res[len] = nums[left] * nums[left];
                len--;
                left++;
            }else{
                res[len] = nums[right] * nums[right];
                len--;
                right--;
            }
        }
        return res;
    }
}

package Array;

/**
 * @Author Lc
 * @Date 2023/10/1
 * @PackageName: Array
 * @ClassName: LeetCode704
 * @Description:
 */

public class LeetCode704 {
    public int search(int[] nums, int target) {
        int len = nums.length;
        //左边界
        int left = 0;
        //右边界
        int right = len -1;
        int mid = 0;
        while(left < right){
            mid = (left + right) /2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] <= target){
                mid++;
                left = mid;
            }else if(nums[mid] >= target){
                mid--;
                right = mid;
            }
        }
        return -1;
    }
}

package Array;

/**
 * @Author Lc
 * @Date 2023/10/5
 * @PackageName: Array
 * @ClassName: LeetCode27
 * @Description: 移除元素
 */

public class LeetCode27 {
    public int removeElement(int[] nums, int val) {
        int left = 0;
        int right = nums.length -1;
        while(right >= 0 && nums[right] == val){
            right--;
        }
        while(left <= right){
            if(nums[left] == val){
                nums[left] = nums[right];
                right--;
            }
            left++;
            while(right >= 0 && nums[right] == val) right--;
        }
        return left;
    }
}

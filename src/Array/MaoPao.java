package Array;

import java.util.Arrays;

/**
 * @Author Lc
 * @Date 2023/9/24
 * @PackageName: Array
 * @ClassName: maopao
 * @Description:
 */

public class MaoPao {
    public static void main(String[] args) {
        int[] sort = sort(new int[]{3, 9, -1, 10, -2});
        System.out.println(Arrays.toString(sort));
    }

    public static int [] sort(int [] nums){
        int temp = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length -1 - i; j++){
                if(nums[j] > nums[j+1]){
                    temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                }
            }
        }
        return nums;
    }
}

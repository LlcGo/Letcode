package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: backtracking
 * @ClassName: Leetcode98
 * @Description: 子集
 */

public class Leetcode98 {

    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 3});
    }

    static List<Integer> path = new ArrayList();
    static List<List<Integer>> res = new ArrayList();
    public static List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        sub(nums,0,size);
        return res;
    }

    public static void sub(int [] nums,int startIndex,int size){
        res.add(new ArrayList(path));
        if(path.size() == size){
            return;
        }
        for(int i = startIndex; i < nums.length; i++){
            path.add(nums[i]);
            sub(nums,i+1,size);
            size -= 1;
            path.remove(path.size() - 1);
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/17
 * @PackageName: backtracking
 * @ClassName: Leetcode46
 * @Description: 全排列
 */

public class Leetcode46 {

    public static void main(String[] args) {
        List<List<Integer>> permute = permute(new int[]{1, 2, 3});
        System.out.println(permute);
    }

    static List<Integer> path = new ArrayList();
    static List<List<Integer>> res = new ArrayList();
    static boolean [] use;
    public static List<List<Integer>> permute(int[] nums) {
        use = new boolean[nums.length];
        per(nums,use);
        return res;
    }

    public static void per(int [] nums,boolean [] use){
        if(path.size() == nums.length){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(use[i]){
                continue;
            }
            use[i] = true;
            path.add(nums[i]);
            per(nums,use);
            use[i] = false;
            path.remove(path.size()-1);
        }
    }
}

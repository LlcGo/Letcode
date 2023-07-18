package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/18
 * @PackageName: backtracking
 * @ClassName: Leetcode47
 * @Description: 全排列 Ⅱ
 */

public class Leetcode47 {
    public static void main(String[] args) {
        List<List<Integer>> permute = permuteUnique(new int[]{1, 1, 2});
        System.out.println(permute);
    }
    static List<Integer> path = new ArrayList();
    static List<List<Integer>> res = new ArrayList();
    static boolean [] use;
    public static  List<List<Integer>> permuteUnique(int[] nums) {
        use = new boolean[nums.length];
        Arrays.sort(nums);
        per(nums,use);
        return res;
    }

    public static void per(int [] nums,boolean [] use){
        if(path.size() == nums.length){
            System.out.println(new ArrayList<>(path));
            res.add(new ArrayList(path));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(use[i]){
                continue;
            }
            if(i > 0 && nums[i] == nums[i-1] && use[i-1]){
                return;
            }
            use[i] = true;
            path.add(nums[i]);
            per(nums,use);
            use[i] = false;
            path.remove(path.size()-1);
        }
    }
}

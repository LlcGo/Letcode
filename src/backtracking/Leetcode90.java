package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/15
 * @PackageName: backtracking
 * @ClassName: Leetcode90
 * @Description: 子集Ⅱ
 */

public class Leetcode90 {
    private static boolean[] used = new boolean[3];
    public static void main(String[] args) {
        List<List<Integer>> subsets = subsets(new int[]{1, 2, 2});
        System.out.println(subsets);
    }

        static List<List<Integer>> result = new ArrayList<>();// 存放符合条件结果的集合
        static LinkedList<Integer> path = new LinkedList<>();// 用来存放符合条件结果
        public static List<List<Integer>> subsets(int[] nums) {
            subsetsHelper(nums, 0);
            return result;
        }

        private static void subsetsHelper(int[] nums, int startIndex){
            result.add(new ArrayList<>(path));
            if (startIndex >= nums.length){
                return;
            }
            for (int i = startIndex; i < nums.length; i++){
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                subsetsHelper(nums, i + 1);
                path.removeLast();
                used[i] = false;
            }
        }

}

package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/11
 * @PackageName: backtracking
 * @ClassName: Leetcode40
 * @Description: 组合的总和Ⅱ
 */

public class Leetcode40 {
    public static void main(String[] args) {
        List<List<Integer>> lists = combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }

    static List<List<Integer>> res = new ArrayList();
    static List<Integer> path = new ArrayList();
    static boolean[] used;
    static int num;
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates);
        combin(candidates,target,num,0);
        return res;
    }
    public static void combin(int [] candidates, int target, int num, int startIndex){
        if(num > target){
            return;
        }
        if(num == target){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex ; i < candidates.length; i++){
            if( i> 0 && candidates[i] == candidates[i-1] && !used[i-1]){
                continue;
            }
            num += candidates[i];
            path.add(candidates[i]);
            used[i] = true;
            combin(candidates,target,num,i+1);
            used[i] = false;
            num -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}

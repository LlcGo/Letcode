package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/10
 * @PackageName: backtracking
 * @ClassName: leetCode39
 * @Description: 组合总和
 */

public class leetCode39 {
    public static void main(String[] args) {
        combinationSum(new int[]{2,3,6,7},7);
    }
    //收获结果集
    static List<List<Integer>> res =  new ArrayList();
    static List<Integer> path  = new LinkedList<>();
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        int num = 0;
        combin(num,candidates,0,target);
        return res;
    }

    public static void combin(int num,int[] candidates,int startIndex,int target){
        if(num > target){
            return;
        }
        if(num == target){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = startIndex; i < candidates.length; i++){
            path.add(candidates[i]);
            num += candidates[i];
            combin(num,candidates,i,target);
            num -= candidates[i];
            path.remove(path.size() - 1);
        }
    }
}

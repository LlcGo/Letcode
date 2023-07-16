package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/16
 * @PackageName: backtracking
 * @ClassName: Leetcode491
 * @Description: 递增子序列
 */

public class Leetcode491 {
    List<Integer> path = new ArrayList();
    List<List<Integer>> res = new ArrayList();
    public List<List<Integer>> findSubsequences(int[] nums) {
        find(nums,0);
        return res;
    }

    public void find(int [] nums,int startIndex){
        if(path.size() >= 2){
            res.add(new ArrayList(path));
        }
        HashSet<Integer> hs = new HashSet<>();
        for(int i = startIndex; i < nums.length; i++){
            if(!path.isEmpty() && path.get(path.size() -1 ) > nums[i] || hs.contains(nums[i])){
                continue;
            }
            hs.add(nums[i]);
            path.add(nums[i]);
            find(nums,i+1);
            path.remove(path.size() - 1);
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/8
 * @Description 组合总和 3
 */
public class Leetcode216 {
    List<List<Integer>> result = new ArrayList();
    LinkedList<Integer> path = new LinkedList();
    public List<List<Integer>> combinationSum3(int k, int n) {
        combin(n,k, 1,0);
        return result;
    }
    public void combin(int targetSum,int k,int startIndex ,int sum){
        if(path.size() == k){
            if(sum == targetSum){
                result.add(new ArrayList<>(path));
            }
            return;
        }
        for(int i = startIndex; i <= 9; i++){
            path.add(i);
            sum += i;
            combin(targetSum,k,i+1,sum);
            path.removeLast();
            sum -= i;
        }
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/7
 * @Description 分组
 */
public class Leetcode77 {
    public static void main(String[] args) {
        List<List<Integer>> combine = combine(4, 2);
    }
    static List<List<Integer>> result = new ArrayList<>();

    //路径
    static LinkedList<Integer> path = new LinkedList<>();

    public static List<List<Integer>> combine(int n, int k) {
        //初始是1
        back(n,k,1);
        return result;
    }

    //startIndex,下次从哪里开始取
    public static void back(int n,int k,  int startIndex){
        //当什么时候退出递归结束，当你收集到了所需要的数的个数时候
        if(path.size() == k){
            result.add(new ArrayList<>(path));
            return;
        }
        //第一个从1开始，第二个从2开始 startIndex慢慢    增加  n个数字
        for(int i = startIndex; i <= n ; i++){
            path.add(i);
            //下一层的索引肯定比现在多1
            back(n,k,i+1);
            //每次递归结束之后要取掉最后一位数，才能做到是俩个数
            path.removeLast();
        }
    }
}

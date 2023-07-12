package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/12
 * @PackageName: backtracking
 * @ClassName: Leetcode131
 * @Description: 切割回文子串
 */

public class Leetcode131 {

    List<String> path = new ArrayList();
    List<List<String>> res = new ArrayList();
    public List<List<String>> partition(String s) {
        par(s,0);
        return res;
    }
    public void par(String s,int startIndex){
        //如果 当前已经切割到底了
        if(startIndex >= s.length()){
            res.add(new ArrayList(path));
            return;
        }
        for(int i = startIndex; i < s.length(); i++){
            if(isPalindrome(s,startIndex,i)){
                String str = s.substring(startIndex, i + 1);
                path.add(str);
            }else{
                continue;
            }
            par(s,i+1);
            path.remove(path.size() - 1);
        }
    }

    //判断是否为子串
    private boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
}

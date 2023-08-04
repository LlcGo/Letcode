package cupidity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/8/4
 * @PackageName: cupidity
 * @ClassName: LeetCode763
 * @Description: 划分字母区间
 */

public class LeetCode763 {
    public List<Integer> partitionLabels(String s) {
        //用27个hash存储字母出现的最远的位置；
        int hash[] = new int[27];
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length; i++){
            //记录每一个下标最长的位子
            hash[chars[i] - 'a'] = i;
        }
        List res =new ArrayList<Integer>();
        //记录区间位置
        int left = 0;
        int right = 0;
        //遍历数组获取最后的结果
        for(int i = 0; i < chars.length; i++){
            //记录每一次的最长找到边界
            right = Math.max(right,hash[chars[i] - 'a']);
            //当边界等于最大值的时候收割
            if(right == i){
                res.add(right-left+1);
                left = i + 1;
            }
        }
        return res;
    }
}

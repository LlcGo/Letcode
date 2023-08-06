package cupidity;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author Lc
 * @Date 2023/8/6
 * @PackageName: cupidity
 * @ClassName: LeetCode56
 * @Description: 合并区间
 */

public class LeetCode56 {
    public int[][] merge(int[][] intervals) {
        LinkedList<int[]> res = new LinkedList();
        //先排序
        Arrays.sort(intervals,(a, b)-> Integer.compare(a[0],b[0]));
        //先放入第一个方便后面修改
        res.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            if(res.getLast()[1] >= intervals[i][0] ){
                //如果重叠
                int start = res.getLast()[0];
                int end = Math.max(res.getLast()[1],intervals[i][1]);
                res.removeLast();
                res.add(new int[]{start,end});
            }else{
                //不重叠直接放入
                res.add(intervals[i]);
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}

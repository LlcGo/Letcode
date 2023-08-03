package cupidity;

import java.util.Arrays;

/**
 * @Author Lc
 * @Date 2023/8/3
 * @PackageName: cupidity
 * @ClassName: LeetCode435
 * @Description: 无重叠区间
 */

public class LeetCode435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        //将所有的开始的位置从小到大排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        for(int i = 1; i < intervals.length;i++){
            //这个区间的头的距离比上一个区间的尾的距离是大与等于，补充和
            if(intervals[i][0]>=intervals[i-1][1]){
                continue;
            }else{
                result++;
                //更新现在这个区间的右边区间,去最小值
                intervals[i][1] = Math.min(intervals[i][1],intervals[i-1][1]);
            }
        }
        return result;
    }
}

package cupidity;

import java.util.Arrays;

/**
 * @Author Lc
 * @Date 2023/8/2
 * @PackageName: cupidity
 * @ClassName: LeetCode452
 * @Description: 用最少数量的箭引爆气球
 */

public class LeetCode452 {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));
        //如果只有一个气球的情况下也需要一个弓箭
        int count = 1;
        for(int i = 1; i < points.length; i++){
            if(points[i][0] > points[i-1][1]){
                count++;
            }else{
                //更新重合气球最小有边界
                points[i][1] = Math.min(points[i][1],points[i-1][1]);
            }
        }
        return count;
    }
}

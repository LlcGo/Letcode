package cupidity;

import java.util.Arrays;

/**
 * @Author Lc
 * @Date 2023/7/22
 * @PackageName: cupidity
 * @ClassName: LeetCode455
 * @Description: 分配饼干
 */

public class LeetCode455 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        int index = s.length - 1;
        for(int i = g.length-1; i >=0 ; i--){
            if(index >=0 && s[index] >= g[i]){
                index--;
                count++;
            }
        }
        return count;
    }
}

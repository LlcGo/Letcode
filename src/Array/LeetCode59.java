package Array;

/**
 * @Author Lc
 * @Date 2023/10/9
 * @PackageName: Array
 * @ClassName: LeetCode59
 * @Description: 59.螺旋矩阵Ⅱ
 */

public class LeetCode59 {
    public int[][] generateMatrix(int n) {
        int loop = 0; //控制循环次数
        int [][] res = new int[n][n];
        int start = 0; //从0开始的下标
        int count = 1;
        int i ,j;
        while(loop++ < n / 2){ //控制边界 loop 从1开始
            //第一层
            for(j = start ;j < n-loop; j++){
                res[start][j] = count++;
            }
            //竖着第二层
            for(i = start;i< n-loop;i++){
                res[i][j] = count++;
            }
            //横着第三层
            for(;j >= loop; j--){
                res[i][j] = count++;
            }
            for(;i >= loop; i--){
                res[i][j] = count++;
            }
            start++;
        }
        //如果是奇数那就代表还有一个位置需要填充
        if(n % 2 == 1){
            res[start][start] = count;
        }
        return res;
    }
}

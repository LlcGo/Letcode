package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/30
 * @PackageName: cupidity
 * @ClassName: LeectCode135
 * @Description: 分发糖果
 */

public class LeetCode135 {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] candyVec = new int[len];
        candyVec[0] = 1;
        //从第二个开始比较所以从1开始
        for(int i = 1; i < len; i++){
            //右边比左边的孩子分数高
            if(ratings[i] > ratings[i-1]){
                //比左边的孩子多一个糖果
                candyVec[i] = candyVec[i-1] +1;
            }else{
                candyVec[i] = 1;
            }
        }
        //倒数开始遍历从最后开始比较当前的和前一个的值
        for(int i = len -2 ; i >= 0;i--){
            if(ratings[i] > ratings[i+1]){
                //现在获得的分数和之前获得分数做一个比较只要最大的
                candyVec[i] = Math.max(candyVec[i+1] +1,candyVec[i]);
            }
        }
        int sum = 0;
        for(int i = 0;i<ratings.length;i++){
            sum +=candyVec[i];
        }
        return sum;

    }
}

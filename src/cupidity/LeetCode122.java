package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/25
 * @PackageName: cupidity
 * @ClassName: LeetCode122
 * @Description: 买卖股票最佳时机Ⅱ
 */

public class LeetCode122 {
    public int maxProfit(int[] prices) {
        int result = 0;
        int num = 0;
        for(int i = 1; i < prices.length ; i++){
            num = prices[i] - prices[i-1];
            if(num > 0){
                result += num;
            }
        }
        return result;
    }
}

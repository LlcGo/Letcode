package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/29
 * @PackageName: cupidity
 * @ClassName: LeetCode134
 * @Description: 加油站
 */

public class LeetCode134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //当前剩余的油量
        int currentSum = 0;
        //每段剩余油量的总和
        int totalSum = 0;
        //开始的出发的起点
        int start = 0;
        for(int i = 0;i < gas.length; i++){
            currentSum += gas[i] - cost[i];
            totalSum += gas[i] - cost[i];
            //如果当前的油量小于 0了，就开始调整开始的油量
            if(currentSum < 0){
                //重新的起点从i+1开始
                start = i+1;
                currentSum = 0;
            }
        }
        if(totalSum < 0){
            return -1;
        }
        return start;
    }
}

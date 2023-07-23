package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/23
 * @PackageName: cupidity
 * @ClassName: LeetCode376
 * @Description: 摆动序列
 */

public class LeetCode376 {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length <= 1){
            return 1;
        }
        //最开始的坡度，默认有一个坡度为0这样就 能够模拟有三个数的情况
        int prediff = 0;
        //下去的坡度
        int curdiff = 0;
        //默认最后面就有一个摆动
        int result = 1;
        //少遍历最后一位，原因是本来就把最后以为的摆动加上去了，默认有一个摆动
        for(int i = 0; i< nums.length -1;i++){
            curdiff = nums[i+1] - nums[i];
            if((prediff >= 0 && curdiff < 0)||(prediff <=0 && curdiff > 0)){
                result++;
                //当出现摆动的时候我们再去更新前一个记录
                prediff = curdiff;
            }
        }
        return result;
    }
}

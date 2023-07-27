package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/27
 * @PackageName: cupidity
 * @ClassName: LeetCode45
 * @Description: 跳跃游戏Ⅱ
 */

public class LeetCode45 {
        public int jump(int[] nums) {
            //当前的覆盖范围
            int cover = 0;
            //下一个的覆盖范围
            int next = 0;
            //记录跳了几次
            int count = 0;
            for(int i = 0;i < nums.length;i++){
                //下一个覆盖范围和前一个覆盖范围做比较，只要最大的
                next = Math.max(i+nums[i],next);
                //如果已经走到了最大范围了
                if(i==cover){
                    //并且还没有到重点
                    if(cover != nums.length - 1){
                        //就要开始跳下一个
                        count++;
                        cover = next;
                        //如果已经能超过最终长度了
                        if(cover >= nums.length - 1){
                            break;
                        }
                    }else{
                        //如果等于了就是跳到了直接返回
                        break;
                    }
                }
            }
            return count;
        }
}

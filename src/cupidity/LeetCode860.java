package cupidity;

/**
 * @Author Lc
 * @Date 2023/7/31
 * @PackageName: cupidity
 * @ClassName: LeetCode860
 * @Description: 柠檬水找零
 */

public class LeetCode860 {
    public boolean lemonadeChange(int[] bills) {
    //每一张前的剩余数量
    int five =0,ten=0,tw=0;
     for(int i = 0; i < bills.length; i++){
        //如果是5就++
        if(bills[i] == 5){
            five++;
        }
        if(bills[i] == 10){
            //如果手里有一张5
            if(five > 0){
                five--;
                ten++;
            }else{
                return false;
            }
        }
        if(bills[i] == 20){
            //优先使用10
            if(ten > 0 && five >0){
                ten--;
                five--;
                tw++;
            }else if(five >= 3){
                five -= 3;
                tw++;
            }else{
                return false;
            }
        }
    }
     return true;
}
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/14
 * @PackageName: backtracking
 * @ClassName: Leetcode93
 * @Description: 合法ip地址
 */

public class Leetcode93 {

    List<String> res = new ArrayList();
    public List<String> restoreIpAddresses(String s) {
        if(s.length() > 12){
            return res;
        }
        backTrack(s, 0, 0);
        return res;
    }

    public void backTrack(String s, int startIndex,int pumsun){
        if(pumsun == 3){
            if(isValid(s,startIndex,s.length()-1)){
                res.add(s);
            }
            return;
        }
        for(int i =startIndex; i < s.length(); i++){
            if (isValid(s, startIndex, i)) {
                s = s.substring(0, i + 1) + "." + s.substring(i + 1);    //在str的后⾯插⼊⼀个逗点
                pumsun++;
                backTrack(s, i + 2, pumsun);// 插⼊逗点之后下⼀个⼦串的起始位置为i+2
                pumsun--;// 回溯
                s = s.substring(0, i + 1) + s.substring(i + 2);// 回溯删掉逗点
            } else {
                break;
            }
        }
    }

    public Boolean isValid(String s, int start, int end){
        if(start > end){
            return false;
        }
        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
            return false;
        }
        int num = 0;
        for(int i = start; i<= end; i++){
            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
                return false;
            }
            num = num * 10 + (s.charAt(i) - '0');
            if (num > 255) { // 如果⼤于255了不合法
                return false;
            }
        }
        return true;
    }
}

package backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Lc
 * @Date 2023/7/9
 * @PackageName: backtracking
 * @ClassName: Leetcode17
 * @Description: 电话号码的字母组合问题
 */
public class Leetcode17 {

    public static void main(String[] args) {
        letterCombinations("23");
    }

    //存储结果的返回值
    static List<String> res = new ArrayList();
    //临时进行增加和删除字符串
    static StringBuilder temp = new StringBuilder();
    public static List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return res;
        }
        //号码映射
        String [] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        combin(digits,numString,0);
        return res;
    }

    /**
     *
     * @param digits 题目
     * @param numString 号码的映射
     * @param index 字符串下标
     */
    public static   void combin(String digits,String[] numString, int index){
        //当下标到字符串的长度 也就是取的数值已经超过了要去的下标长度 1次，就能够取到 下标范围内的所有的字母
        if(digits.length() == index){
            res.add(temp.toString());
            return;
        }
        //获取映射后的字符串  例如 ‘1’-‘0’ = 1  实际上 49-48 = 1
        String str = numString[digits.charAt(index) - '0'];
        for(int i = 0; i < str.length(); i++){
            temp.append(str.charAt(i));
            combin(digits,numString,index + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }
}

package cupidity;

/**
 * @Author Lc
 * @Date 2023/8/7
 * @PackageName: cupidity
 * @ClassName: LeetCode738
 * @Description: 单调递增的数字
 */

public class LeetCode738 {
    public int monotoneIncreasingDigits(int n) {
        //1.先把n变为string方便之后更改
        String s = String.valueOf(n);
        char[] chars = s.toCharArray();
        //2.标记之后全部要改成9
        int start = s.length();
        for (int i = s.length() - 2; i >= 0; i--) {
            if (chars[i] > chars[i + 1]) {
                chars[i]--;
                start = i+1;
            }
        }
        for (int i = start; i < s.length(); i++) {
            chars[i] = '9';
        }
        return Integer.parseInt(String.valueOf(chars));
    }
}

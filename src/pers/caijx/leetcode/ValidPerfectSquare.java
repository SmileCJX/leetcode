package pers.caijx.leetcode;

/**
 Given a positive integer num, write a function which returns True if num is a perfect square else False.

 Note: Do not use any built-in library function such as sqrt.

 Example 1:

 Input: 16
 Returns: True

 Example 2:

 Input: 14
 Returns: False

 * Created by Administrator on 2018/4/7/007.
 */
public class ValidPerfectSquare {

    /**
     A square number is 1+3+5+7+..., JAVA code
     根据等差数列公式
     * @param num
     * @return
     */
    public boolean isPerfectSquare(int num) {
        int i = 1;
        while (num > 0) {
            num -= i;
            i += 2;
        }
        return num == 0;
    }
}

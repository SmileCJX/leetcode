package pers.caijx.leetcode;

/**
 Given an integer n, return the number of trailing zeroes in n!.

 Note: Your solution should be in logarithmic time complexity.
 * Created by Administrator on 2018/3/7/007.
 */
public class FactorialTrailingZeroes {

    /**
     * 题目的意思是要求一个整数的阶乘末尾有多少个0；

     1.需要注意的是后缀0是由2，5相乘得来，因此只需看有多少个2，5即可
     n = 5: 5!的质因子中 (2 * 2 * 2 * 3 * 5)包含一个5和三个2。因而后缀0的个数是1。
     n = 11: 11!的质因子中(2^8 * 3^4 * 5^2 * 7)包含两个5和三个2。于是后缀0的个数就是2。

     2质因子中2的个数总是大于等于5的个数。因此只要计数5的个数就可以了。

     例如： 11中有两个5因此输出2.可用 n/5=2;

     3.需要注意的是25中有25，20，15，10，5，但是25又可以分为5*5，
     因此需要判断t=n/5后中t的5个数
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n/5;
            n /= 5;
        }
        return count;
    }

    public static void main(String[] args) {
        FactorialTrailingZeroes demo = new FactorialTrailingZeroes();
        System.out.println(demo.trailingZeroes(11));
    }
}

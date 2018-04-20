package pers.caijx.leetcode;

/**
 We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.

 Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 Example:
 Input: 28
 Output: True
 Explanation: 28 = 1 + 2 + 4 + 7 + 14
 Note: The input number n will not exceed 100,000,000. (1e8)


 * Created by Administrator on 2018/4/20/020.
 */
public class PerfectNumber {

    public boolean checkPerfectNumber(int num) {
        if (num < 2) {
            return false;
        }
        int sum = 1;
        for (int x = 2; x * x <= num; x++) {
            if (num % x == 0) {
                sum += x;
                sum += num / x;
            }
        }
        return sum == num;
    }

    public static void main(String[] args) {
        PerfectNumber instance = new PerfectNumber();
        System.out.println(instance.checkPerfectNumber(28));
    }
}

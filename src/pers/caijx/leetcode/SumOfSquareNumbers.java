package pers.caijx.leetcode;

import java.util.HashSet;

/**
 Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.

 Example 1:
 Input: 5
 Output: True
 Explanation: 1 * 1 + 2 * 2 = 5
 Example 2:
 Input: 3
 Output: False
 * Created by Administrator on 2018/5/2/002.
 */
public class SumOfSquareNumbers {

    public boolean judgeSquareSum(int c) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i <= Math.sqrt(c); i++) {
            set.add(i * i);
            if (set.contains(c - i * i)) {
                return true;
            }
        }
        return false;
    }
}

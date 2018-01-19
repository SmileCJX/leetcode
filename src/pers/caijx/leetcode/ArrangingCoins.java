package pers.caijx.leetcode;

/**
 You have a total of n coins that you want to form in a staircase shape,
 where every k-th row must have exactly k coins.

 Given n, find the total number of full staircase rows that can be formed.

 n is a non-negative integer and fits within the range of a 32-bit signed integer.

 Example 1:

 n = 5

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤

 Because the 3rd row is incomplete, we return 2.
 Example 2:

 n = 8

 The coins can form the following rows:
 ¤
 ¤ ¤
 ¤ ¤ ¤
 ¤ ¤

 Because the 4th row is incomplete, we return 3.
 * Created by Administrator on 2018/1/19/019.
 */
public class ArrangingCoins {

    public static int arrangeCoins(int n) {
        int cur = 1;
        int rem = n - 1;
        while (rem >= cur + 1) {
            ++cur;
            rem -= cur;
        }
        return n == 0 ? 0 : cur;
    }

    public static void main(String[] args) {
        System.out.println(arrangeCoins(8));
    }
}

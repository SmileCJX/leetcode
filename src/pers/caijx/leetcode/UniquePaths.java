package pers.caijx.leetcode;

/**
 A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

 The robot can only move either down or right at any point in time.
 The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

 How many possible unique paths are there?


 Above is a 7 x 3 grid. How many possible unique paths are there?

 Note: m and n will be at most 100.

 Example 1:

 Input: m = 3, n = 2
 Output: 3
 Explanation:
 From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 1. Right -> Right -> Down
 2. Right -> Down -> Right
 3. Down -> Right -> Right
 Example 2:

 Input: m = 7, n = 3
 Output: 28
 * Created by caijx on 2018/7/6/006.
 */
public class UniquePaths {

    /**
     根据题目可知，从起点到终点的总步数是一定的，右行或下行的次数也是一定的。
     我们只需要确定在总部数中哪些步数右行或是哪些步数下行即可知道其对应的路径。这里运用到排列组合的思想
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {
        int totalPath = m + n - 2;
        int down = m - 1;
        int right = n - 1;
        if (down == 0 || right == 0) {
            return 1;
        }
        int count = Math.min(down,right);
        long result = 1;
        for (int i = 1; i <= count; i++) {
            result *= totalPath--;
            result /= i;
        }
        return (int)result;
    }
}

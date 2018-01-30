package pers.caijx.leetcode;

/**
 You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.


 Example 1:

 Input: 2
 Output:  2
 Explanation:  There are two ways to climb to the top.

 1. 1 step + 1 step
 2. 2 steps
 Example 2:

 Input: 3
 Output:  3
 Explanation:  There are three ways to climb to the top.

 1. 1 step + 1 step + 1 step
 2. 1 step + 2 steps
 3. 2 steps + 1 step
 * Created by Administrator on 2018/1/30/030.
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    /**
     * In this brute force approach we take all possible step combinations i.e. 1 and 2, at every step.
     * At every step we are calling the function climbStairsclimbStairs for step 11 and 22,
     * and return the sum of returned values of both functions.

     climbStairs(i,n)=(i + 1, n) + climbStairs(i + 2, n)climbStairs(i,n)=(i+1,n)+climbStairs(i+2,n),
     where ii defines the current step and nn defines the destination step.


     Complexity Analysis

     Time complexity : O(2^n)O(2
     ​n
     ​​ ). Size of recursion tree will be 2^n2
     ​n
     ​​ .

     Recursion tree for n=5 would be like this:
     * @param n
     * @return
     */
    public int climbStairs1(int n) {
        return climb_Stairs1(0,n);
    }

    public int climb_Stairs1(int i,int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_Stairs1(i + 1,n) + climb_Stairs1(i + 2,n);
    }

    /**
     Approach #2 Recursion with memorization [Accepted]
     Algorithm

     In the previous approach we are redundantly calculating the result for every step.
     Instead, we can store the result at each step in memomemo array and directly returning the result from the memo array whenever that function is called again.

     In this way we are pruning recursion tree with the help of memomemo array and reducing the size of recursion tree upto nn.

     Complexity Analysis

     Time complexity : O(n)O(n). Size of recursion tree can go upto nn.

     Space complexity : O(n)O(n). The depth of recursion tree can go upto nn.
     * @param n
     * @return
     */
    public int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climb_Stairs2(0,n,memo);
    }

    private int climb_Stairs2(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_Stairs2(i + 1,n,memo) + climb_Stairs2(i + 2,n,memo);
        return memo[i];
    }


    public static void main(String[] args) {
        ClimbingStairs climbingStairs = new ClimbingStairs();
        System.out.println(climbingStairs.climbStairs2(44));
    }
}

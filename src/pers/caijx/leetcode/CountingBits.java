package pers.caijx.leetcode;

/**
 Given a non negative integer number num.
 For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.

 Example 1:

 Input: 2
 Output: [0,1,1]
 Example 2:

 Input: 5
 Output: [0,1,1,2,1,2]
 Follow up:

 It is very easy to come up with a solution with run time O(n*sizeof(integer)). But can you do it in linear time O(n) /possibly in a single pass?
 Space complexity should be O(n).
 Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 统计从0到n每个数的二进制写法的1的个数，存入一个一维数组中返回，题目中明确表示不希望我们一个数字一个数字，一位一位的傻算，
 而是希望我们找出规律，而且题目中也提示了我们注意[2-3], [4-7], [8-15]这些区间的规律
 * Created by caijx on 2018/8/27/027.
 */
public class CountingBits {

    /**
     * Example

     set dp[0]=0
     set dp[1]=1
     Now,
     dp[2]=dp[0]+1
     dp[3]=dp[1]+1

     dp[4]=dp[0]+1
     dp[5]=dp[1]+1
     dp[6]=dp[2]+1
     dp[7]=dp[3]+1

     and so on.....
     * @param num
     * @return
     */
    public int[] countBits(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int dp[] = new int[num + 1];
        dp[0] = 0;
        dp[1] = 1;
        int temp = 2;
        int counter = 2;
        for (int i = 2; i <= num; i++) {
            if (counter == 0) {
                temp = temp * 2;
                counter = temp;
            }
            dp[i] = dp[i % temp] + 1;
            counter--;
        }
        return dp;
    }

    public static void main(String[] args) {

    }
}

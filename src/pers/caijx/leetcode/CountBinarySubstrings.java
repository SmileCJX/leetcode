package pers.caijx.leetcode;

/**
 Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.

 Substrings that occur multiple times are counted the number of times they occur.

 Example 1:
 Input: "00110011"
 Output: 6
 Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".

 Notice that some of these substrings repeat and are counted the number of times they occur.

 Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 Example 2:
 Input: "10101"
 Output: 4
 Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 Note:

 s.length will be between 1 and 50,000.
 s will only consist of "0" or "1" characters.
 * Created by Administrator on 2018/5/10/010.
 */
public class CountBinarySubstrings {

    /**
     使用2个变量来存储当前数字前的数字连续次数pre以及当前数字的连续次数cur。
     如果当前数字与前一个数字连续，则计算出当前数字连续的次数cur，否则统计当前数字之前的数字连续次数pre并令当前数字连续次数cur为1。
     接着通过判断统计子数组的个数，如果这时该数字之前的数字连续次数pre大于等于当前数字连续次数cur，则令子数组个数res加1
     * @param s
     * @return
     */
    public int countBinarySubstrings(String s) {
        int pre = 0;
        int cur = 1;
        int res = 0;
        for (int i = 1; i != s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        CountBinarySubstrings instance = new CountBinarySubstrings();
        System.out.println(instance.countBinarySubstrings("00110011"));
    }
}

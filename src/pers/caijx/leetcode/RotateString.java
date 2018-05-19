package pers.caijx.leetcode;

/**
 We are given two strings, A and B.

 A shift on A consists of taking string A and moving the leftmost character to the rightmost position.
 For example, if A = 'abcde', then it will be 'bcdea' after one shift on A. Return True if and only if A can become B after some number of shifts on A.

 Example 1:
 Input: A = 'abcde', B = 'cdeab'
 Output: true

 Example 2:
 Input: A = 'abcde', B = 'abced'
 Output: false
 Note:

 A and B will have length at most 100.

 * Created by Administrator on 2018/5/19/019.
 */
public class RotateString {

    public boolean rotateString(String A, String B) {
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        A = new StringBuilder(A).append(A).toString();
        return A.contains(B);
    }

    public static void main(String[] args) {
        RotateString instance = new RotateString();
        System.out.println(instance.rotateString("abcde","cdeab"));
    }
}

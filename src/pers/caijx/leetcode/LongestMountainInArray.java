package pers.caijx.leetcode;

/**
 Let's call any (contiguous) subarray B (of A) a mountain if the following properties hold:

 B.length >= 3
 There exists some 0 < i < B.length - 1 such that B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 (Note that B could be any subarray of A, including the entire array A.)

 Given an array A of integers, return the length of the longest mountain.

 Return 0 if there is no mountain.



 Example 1:

 Input: [2,1,4,7,3,2,5]
 Output: 5
 Explanation: The largest mountain is [1,4,7,3,2] which has length 5.
 Example 2:

 Input: [2,2,2]
 Output: 0
 Explanation: There is no mountain.
 * Created by Administrator on 2018/6/5/005.
 */
public class LongestMountainInArray {

    public int longestMountain(int[] A) {
        int go = 0;
        int down = 0;
        int len = 0;
        for (int i = 0; i < A.length - 1; i++) {
            if (A[i] < A[i + 1]) {
                if (i != 0 && A[i] < A[i - 1]) {
                    go = 0;
                    down = 0;
                }
                go++;
            } else if(A[i] > A[i + 1]) {
                down++;
                if (go != 0) {
                    len = Math.max(len,go + down);
                }
            } else {
                go = 0;
                down = 0;
            }
        }
        if (len < 2) {
            return 0;
        }
        return len + 1;
    }
}

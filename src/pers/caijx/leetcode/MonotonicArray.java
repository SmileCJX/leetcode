package pers.caijx.leetcode;

/**
 An array is monotonic if it is either monotone increasing or monotone decreasing.

 An array A is monotone increasing if for all i <= j, A[i] <= A[j].  An array A is monotone decreasing if for all i <= j, A[i] >= A[j].

 Return true if and only if the given array A is monotonic.
 * Created by caijx on 2018/10/23/023.
 */
public class MonotonicArray {

    public boolean isMontonic(int[] A) {
        boolean inc = true;
        boolean dec = true;
        for (int i = 1; i < A.length; i++) {
            inc &= A[i - 1] <= A[i];
            dec &= A[i - 1] >= A[i];
        }
        return inc || dec;
    }
}

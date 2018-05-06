package pers.caijx.leetcode;

/**
 Given two strings A and B, find the minimum number of times A has to be repeated such that B is a substring of it. If no such solution, return -1.

 For example, with A = "abcd" and B = "cdabcdab".

 Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring of it; and B is not a substring of A repeated two times ("abcdabcd").

 Note:
 The length of A and B will be between 1 and 10000.
 * Created by Administrator on 2018/5/6/006.
 */
public class RepeatedStringMatch {

    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder().append(A);
        for (int i = 1; sb.length() - B.length() <= 2 * A.length(); ++i,sb.append(A)) {
            if (sb.indexOf(B) != -1) {
                return i;
            }
        }
        return -1;
    }
}

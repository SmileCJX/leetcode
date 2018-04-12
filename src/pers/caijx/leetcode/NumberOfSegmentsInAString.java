package pers.caijx.leetcode;

/**
 Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.

 Please note that the string does not contain any non-printable characters.

 Example:

 Input: "Hello, my name is John"
 Output: 5
 * Created by Administrator on 2018/4/12/012.
 */
public class NumberOfSegmentsInAString {

    public int countSegments(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ' && (i == 0 || s.charAt(i - 1) == ' ')) {
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        NumberOfSegmentsInAString instance = new NumberOfSegmentsInAString();
        System.out.println(instance.countSegments("Hello, my name is John"));
    }
}

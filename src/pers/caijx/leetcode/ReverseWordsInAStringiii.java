package pers.caijx.leetcode;

/**
 Given a string, you need to reverse the order of characters in each word within
 a sentence while still preserving whitespace and initial word order.

 Example 1:
 Input: "Let's take LeetCode contest"
 Output: "s'teL ekat edoCteeL tsetnoc"
 Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * Created by Administrator on 2018/3/23/023.
 */
public class ReverseWordsInAStringiii {

    public String reverseWords(String s) {
        String[] str = s.split(" ");
        for (int i = 0; i < str.length; i++) {
            str[i] = new StringBuffer(str[i]).reverse().toString();
        }
        StringBuilder result = new StringBuilder();
        for (String st : str) {
            result.append(st + " ");
        }
        return result.toString().trim();
    }
}

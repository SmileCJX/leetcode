package pers.caijx.leetcode;

/**
 Given a word, you need to judge whether the usage of capitals in it is right or not.

 We define the usage of capitals in a word to be right when one of the following cases holds:

 All letters in this word are capitals, like "USA".
 All letters in this word are not capitals, like "leetcode".
 Only the first letter in this word is capital if it has more than one letter, like "Google".
 Otherwise, we define that this word doesn't use capitals in a right way.
 Example 1:
 Input: "USA"
 Output: True
 Example 2:
 Input: "FlaG"
 Output: False
 Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 判断一个字母是否大小写正确：要么全是大写，要么全是小写，或者首字母大写其他小写，否则不满足题意～
 * Created by Administrator on 2018/1/15/015.
 */
public class DetectCapital {

    public static boolean detectCapitalUse(String word) {
        int cnt = 0;
        for (char c : word.toCharArray()) {
            if ('Z' - c >= 0) {
                cnt++;
            }
        }
        return ((cnt == 0) || (cnt == word.length()) || (cnt == 1 && 'Z' - word.charAt(0) >= 0));
    }

    public static void main(String[] args) {
        System.out.println(detectCapitalUse("USA"));
        System.out.println(detectCapitalUse("FlaG"));
    }
}

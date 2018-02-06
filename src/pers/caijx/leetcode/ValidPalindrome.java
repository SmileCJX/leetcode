package pers.caijx.leetcode;

/**
 Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 Note:
 Have you consider that the string might be empty? This is a good question to ask during an interview.

 For the purpose of this problem, we define empty string as valid palindrome.


 * Created by Administrator on 2018/2/6/006.
 */
public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        String actural = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        String rev = new StringBuffer(actural).reverse().toString();
        return actural.equals(rev);
    }

    public static void main(String[] args) {
        ValidPalindrome validPalindrome = new ValidPalindrome();
        System.out.println(validPalindrome.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(validPalindrome.isPalindrome("race a car"));
    }
}

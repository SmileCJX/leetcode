package pers.caijx.leetcode;

import java.util.HashSet;

/**
 Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

 This is case sensitive, for example "Aa" is not considered a palindrome here.

 Note:
 Assume the length of given string will not exceed 1,010.

 Example:

 Input:
 "abccccdd"

 Output:
 7

 Explanation:
 One longest palindrome that can be built is "dccaccd", whose length is 7.

 * Created by caijx on 2018/8/31/031.
 */
public class LongestPalindrome {

    /**
     * idea is to count the character which are present as odd number.
     question is why ? because if a string is Palindrome and total length even ,
     that means it is having all character count should be multplication of 2 .
     example aabbbbcc, it can form palindrome and it is even
     but if the string length is ODD that means only one character should be one time and rest all character should be multiplication of 2,
     example aacccbb, it can form palindrome but aacccbbb can not form palindrome.
     now for this question check if all characters are multiplication of 2 or not , if yes, then return the string length,
     and if not, then check how many odd numbers characters are there. then minus those extra characters from the string length .
     * @param s
     * @return
     */
    public int longestPalindrome(String s) {
        int inputLength = s.length();
        HashSet<Character> charWithOddNumber = new HashSet<>();
        for (int i = 0 ; i < s.length(); i++) {
            char c = s.charAt(i);
            if (charWithOddNumber.contains(c)) {
                charWithOddNumber.remove(c);
            } else {
                charWithOddNumber.add(c);
            }
        }
        int sizeOfOddNumber = charWithOddNumber.size();
        int palindromeLength = sizeOfOddNumber <= 1 ? inputLength : (inputLength - (sizeOfOddNumber - 1));
        return palindromeLength;
    }
}

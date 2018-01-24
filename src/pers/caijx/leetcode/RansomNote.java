package pers.caijx.leetcode;

/**
 Given an arbitrary ransom note string and another string containing letters from all the magazines,
 write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

 Each letter in the magazine string can only be used once in your ransom note.

 Note:
 You may assume that both strings contain only lowercase letters.

 canConstruct("a", "b") -> false
 canConstruct("aa", "ab") -> false
 canConstruct("aa", "aab") -> true
 题目的意思就是给你两个字符串，判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成，
 第二个字符里的每个字符只能使用一次。（假设只包含小写字母）
 * Created by Administrator on 2018/1/24/024.
 */
public class RansomNote {

    public static boolean canConstruct(String ransomNote, String magazine) {
        int[] arr = new int [26];
        for (int i = 0; i < magazine.length(); i++) {
            arr[magazine.charAt(i) - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            if (--arr[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct("aa","aab"));
        System.out.println(canConstruct("a","aab"));
        System.out.println(canConstruct("ac","aab"));
    }
}

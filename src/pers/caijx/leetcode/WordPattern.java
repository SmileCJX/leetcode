package pers.caijx.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:
 pattern = "abba", str = "dog cat cat dog" should return true.
 pattern = "abba", str = "dog cat cat fish" should return false.
 pattern = "aaaa", str = "dog cat cat dog" should return false.
 pattern = "abba", str = "dog dog dog dog" should return false.
 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 * Created by Administrator on 2018/2/25/025.
 */
public class WordPattern {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        if (words.length != pattern.length()) {
            return false;
        }
        Map index = new HashMap();
        for (Integer i = 0; i < words.length; i++) {
            if (!Objects.equals(index.put(pattern.charAt(i),i),
                    index.put(words[i],i))) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern wordPattern = new WordPattern();
        System.out.println(wordPattern.wordPattern("aaaa","dog dog cat dog"));
    }
}

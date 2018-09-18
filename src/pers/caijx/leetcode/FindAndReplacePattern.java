package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 You have a list of words and a pattern, and you want to know which words in words matches the pattern.

 A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x),
 we get the desired word.

 (Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter,
 and no two letters map to the same letter.)

 Return a list of the words in words that match the given pattern.

 You may return the answer in any order.



 Example 1:

 Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
 Output: ["mee","aqq"]
 Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}.
 "ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation,
 since a and b map to the same letter.


 Note:

 1 <= words.length <= 50
 1 <= pattern.length = words[i].length <= 20
 * Created by caix on 2018/9/18/018.
 */
public class FindAndReplacePattern {

    public List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> matches = new ArrayList<>();
        if (words == null || words.length == 0 || pattern == null || pattern.isEmpty()) {
            return matches;
        }
        for (String word : words) {
            if (verifyPattern(word,pattern)) {
                matches.add(word);
            }
        }
        return matches;
    }

    private boolean verifyPattern(String word, String pattern) {
        return false;
    }
}

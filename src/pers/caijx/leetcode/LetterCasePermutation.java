package pers.caijx.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 Given a string S, we can transform every letter individually to be lowercase or uppercase to create another string.
 Return a list of all possible strings we could create.

 Examples:
 Input: S = "a1b2"
 Output: ["a1b2", "a1B2", "A1b2", "A1B2"]

 Input: S = "3z4"
 Output: ["3z4", "3Z4"]

 Input: S = "12345"
 Output: ["12345"]
 Note:

 S will be a string with length at most 12.
 S will consist only of letters or digits.
 * Created by Administrator on 2018/5/13/013.
 */
public class LetterCasePermutation {

   public List<String> res;

    public List<String> letterCasePermutation(String s) {
        res = new LinkedList<>();
        helper(s.toCharArray(),0);
        return res;
    }

    private void helper(char[] ca, int idx) {
        if (idx >= ca.length) {
            res.add(new String(ca));
            return;
        }
        if (Character.isDigit(ca[idx])) {
            helper(ca,idx + 1);
        } else {
            ca[idx] = Character.toLowerCase(ca[idx]);
            helper(ca,idx + 1);
            ca[idx] = Character.toUpperCase(ca[idx]);
            helper(ca,idx + 1);
        }
    }
}

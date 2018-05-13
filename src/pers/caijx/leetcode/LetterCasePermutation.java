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

    /**
     Explaination

     if a char is a digit, we only need to do one recursion, and there is no need for toggling between lower and upper cases.

     if a char is a letter, we need to do recursion for both lower and upper cases, since we do not know whether that character is lower or upper at the beginning, we just simply do both separately.
     if we reach the end, we simply add it to the result list

     The reason for using a LinkedList instead of an ArrayList is we are always do insertion for this problem. Since ArrayList automatically resizes itself, using LinkedList is more efficient for insertion.

     Time complexity : O(2^n * n)

     Since in the worst case, all characters are letters. For each of them, it do both upper and lower case. And there will be 2*n strings. Also, for each string, it uses a String constructor, new String(ca), which implemented with Arrays.copyOf, that is O(n). n is the length of String.

     Space complexity: O(2^n * n)

     In the worst case, the total memory needed is O(2^n * n) , including a trivial extra space for holding the answer, a LinkedList.
     * @param s
     * @return
     */
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

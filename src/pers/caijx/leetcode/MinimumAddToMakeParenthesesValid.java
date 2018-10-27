package pers.caijx.leetcode;

import java.util.Stack;

/**
 Given a string S of '(' and ')' parentheses, we add the minimum number of parentheses ( '(' or ')',
 and in any positions ) so that the resulting parentheses string is valid.

 Formally, a parentheses string is valid if and only if:

 It is the empty string, or
 It can be written as AB (A concatenated with B), where A and B are valid strings, or
 It can be written as (A), where A is a valid string.
 Given a parentheses string, return the minimum number of parentheses we must add to make the resulting string valid.
 * Created by caijx on 2018/10/27/027.
 */
public class MinimumAddToMakeParenthesesValid {

    public int minAddToMakeValid(String S) {
        Stack<Character> stack = new Stack<>();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    count++;
                } else if (stack.peek() == '(') {
                    stack.pop();
                } else {
                    count++;
                }
            }
        }
        return count + stack.size();
    }
}

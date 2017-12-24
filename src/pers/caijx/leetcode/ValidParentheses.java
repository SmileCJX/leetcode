package pers.caijx.leetcode;

import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * Created by Administrator on 2017/12/24/024.
 */
public class ValidParentheses {

    public static boolean isValid(String s) {
        Stack<Integer> p = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            int q = "(){}[]".indexOf(s.substring(i, i + 1));
            if(q % 2 == 1) {
                if(p.isEmpty() || p.pop() != q - 1) {
                    return false;
                }
            } else {
                p.push(q);
            }
        }
        return p.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("[()]"));
    }
}

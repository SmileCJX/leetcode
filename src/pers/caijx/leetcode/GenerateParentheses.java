package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 * Created by caijx on 2018/8/31/031.
 * modify by caijx on 2018/11/20
 */
public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List res = new ArrayList();
        StringBuilder sb = new StringBuilder("");
        helper(res,sb,0,0,n);
        return res;
    }

    private void helper(List res, StringBuilder sb, int left, int right, int n) {
        if (left < right || left > n || right > n) {
            return;
        }
        if (left == n && right == n) {
            res.add(sb.toString());
            return;
        }
    }
}

package pers.caijx.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

 Example 1:
 Input:
       5
     / \
    3   6
  / \   \
 2   4   7

 Target = 9

 Output: True
 Example 2:
 Input:
      5
    / \
   3   6
  / \   \
 2   4   7

 Target = 28

 Output: False
 * Created by Administrator on 2018/7/4/004.
 */
public class TwoSumIV {

    public boolean findTarget(TreeNode root, int k) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(root);
        while (!q.isEmpty()) {
            TreeNode l = q.poll();
            if (set.contains(k - l.val)) {
                return true;
            }
            if (!set.contains(l.val)) {
                set.add(l.val);
            }
            if (l.left != null) {
                q.offer(l.left);
            }
            if (l.right != null) {
                q.offer(l.right);
            }
        }
        return false;
    }
}

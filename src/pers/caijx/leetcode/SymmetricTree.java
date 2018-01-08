package pers.caijx.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断二叉树是否对称
 Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

 For example, this binary tree [1,2,2,3,4,4,3] is symmetric:

       1
      / \
     2   2
    / \ / \
   3  4 4  3
 But the following [1,2,2,null,3,null,3] is not:
      1
     / \
    2   2
     \   \
      3   3
 Note:
 Bonus points if you could solve it both recursively and iteratively.
 * Created by Administrator on 2018/1/8/008.
 */
public class SymmetricTree {

    /**
     * 递归解决
     * @param root
     * @return
     */
    public static boolean isSymmetric1(TreeNode root) {
        return isMirror(root,root);
    }

    private static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t1 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isMirror(t1.left,t2.right) && isMirror(t1.right,t2.left);
    }

    /**
     * 迭代解决
     * @param root
     * @return
     */
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode root1 = queue.poll();
            TreeNode root2 = queue.poll();
            if (root1 == null && root2 == null) {
                continue;
            }
            if (root1 == null || root2 == null) {
                return false;
            }
            if (root1.val != root2.val) {
                return false;
            }
            queue.add(root1.left);
            queue.add(root2.right);
            queue.add(root1.right);
            queue.add(root2.left);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isSymmetric1(new TreeNode(20)));
    }
}


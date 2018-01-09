package pers.caijx.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

 For example:
 Given binary tree [3,9,20,null,null,15,7],
   3
  / \
 9  20
   /  \
  15   7
 return its bottom-up level order traversal as:
 [
 [15,7],
 [9,20],
 [3]
 ]
 * Created by Administrator on 2018/1/9/009.
 */
public class BinaryTreeLevelOrderTraversal {

    /**
     * DFS
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom1(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();

        if (root == null) {
            return wrapList;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i = 0; i < levelNum; i++) {
                if (queue.peek().left != null) {
                    queue.offer(queue.peek().left);
                }
                if (queue.peek().right != null) {
                    queue.offer(queue.peek().right);
                }
                subList.add(queue.poll().val);
            }
            wrapList.add(0,subList);
        }
        return wrapList;
    }

    /**
     * bfs
     * @param root
     * @return
     */
    public static List<List<Integer>> levelOrderBottom2(TreeNode root) {
        List<List<Integer>> wrapList = new LinkedList<>();
        levelMaker(wrapList,root,0);
        return wrapList;
    }

    private static void levelMaker(List<List<Integer>> wrapList, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level >= wrapList.size()) {
            wrapList.add(0,new LinkedList<>());
        }
        levelMaker(wrapList,root.left,level+1);
        levelMaker(wrapList,root.right,level+1);
        wrapList.get(wrapList.size() - level - 1).add(root.val);
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.setLeft(new TreeNode(9));
        node.setRight(new TreeNode(20));
        node.right.setLeft(new TreeNode(15));
        node.right.setRight(new TreeNode(7));
        levelOrderBottom2(node);
    }
}

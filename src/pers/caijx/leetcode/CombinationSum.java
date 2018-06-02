package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 * Created by Administrator on 2018/6/2/002.
 */
public class CombinationSum {

    /**
     1. 基本思路是先排好序，这样做的目的是为了对数组后面不可能出现的情况进行排除，有利于减少查找时间，即剪枝操作

     2. 外层循环对数组元素依次进行遍历，依次将 nums 中的元素加入中间集，一旦满足条件，就将中间集加入结果集

     3. 然后每次递归中把剩下的元素一一加到结果集合中，并且把目标减去加入的元素，然后把剩下元素（包括当前加入的元素）放到下一层递归中解决子问题。

     算法复杂度因为是NP问题，所以自然是指数量级的：
     * @param candidates
     * @param target
     * @return
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        dfs(res,temp,target,candidates,0);
        return res;
    }

    private void dfs(List<List<Integer>> res, List<Integer> temp, int target, int[] candidates, int j) {
        if (target == 0) { // 满足条件，将中间集加入结果集
            res.add(new ArrayList<>(temp));
        }
        for (int i = j; i < candidates.length && target >= candidates[i]; i++) { // target >= candidates[i]是剪枝操作
            temp.add(candidates[i]);
            dfs(res,temp,target - candidates[i],candidates,i);
            temp.remove(temp.size() - 1);
        }
    }
}

package pers.caijx.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 Given a directed, acyclic graph of N nodes.  Find all possible paths from node 0 to node N-1, and return them in any order.

 The graph is given as follows:  the nodes are 0, 1, ..., graph.length - 1.  graph[i] is a list of all nodes j for which the edge (i, j) exists.

 Example:
 Input: [[1,2], [3], [3], []]
 Output: [[0,1,3],[0,2,3]]
 Explanation: The graph looks like this:
 0--->1
 |    |
 v    v
 2--->3
 There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
 Note:

 The number of nodes in the graph will be in the range [2, 15].
 You can print different paths in any order, but you should keep the order of nodes inside one path.
 给出了一个有向无环图，求从起点到终点的所有路径。图的表示方法是，共有n个节点，其数字分别为0…n-1，给出的图graph的每个位置对应的是第i个节点能到达的下一个节点的序号位置。
 比如题中graph[0] = [1,2]表示图的起点0指向了1,2两个节点。
 * Created by Administrator on 2018/6/14/014.
 */
public class AllPathsFromSourceToTarget {

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        return dfs(graph,0,new ArrayList<>(),new ArrayList<>());
    }

    private List<List<Integer>> dfs(int[][] graph, int s, List<Integer> path, List<List<Integer>> out) {
        path.add(s);
        if (s == graph.length - 1) {
            out.add(new ArrayList<Integer>(path));
        } else {
            for (int i = 0; i < graph[s].length; i++) {
                dfs(graph,graph[s][i],path,out);
            }
        }
        path.remove(path.size() - 1);
        return out;
    }
}

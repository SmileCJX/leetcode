package pers.caijx.leetcode;

/**
 On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

 Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor,
 and you can either start from the step with index 0, or the step with index 1.

 Example 1:
 Input: cost = [10, 15, 20]
 Output: 15
 Explanation: Cheapest is start on cost[1], pay that cost and go to the top.
 Example 2:
 Input: cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]
 Output: 6
 Explanation: Cheapest is start on cost[0], and only step on 1s, skipping cost[3].
 Note:
 cost will have a length in the range [2, 1000].
 Every cost[i] will be an integer in the range [0, 999].

 * Created by Administrator on 2018/5/11/011.
 */
public class MinCostClimbingStairs {

    /**
     由于在i大于等于2的情况下，dp[i]只跟dp[i-1]和dp[i-2]接cost数组有关。所以我们只需要用三个变量来存储结果即可，
     即dp0,dp1,dp2，这样的空间复杂度就变成了O(1)。
     * @param cost
     * @return
     */
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length + 1;
        int dp0 = 0;
        int dp1 = 0;
        int dp2 = 0;
        for (int i = 2; i < length; i++) {
            dp2 = Math.min(dp0 + cost[i - 2],dp1 + cost[i - 1]);
            dp0 = dp1;
            dp1 = dp2;
        }
        return dp2;
    }

    public int minCostClimbingStairs2(int[] cost) {
        int length = cost.length + 1;
        int[] dp = new int[length];
        int dp0 = 0;
        int dp1 = 0;
        for (int i = 2; i < length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i -1],dp[i - 2] +cost[i - 2]);
        }
        return dp[length - 1];
    }

    public static void main(String[] args) {
        MinCostClimbingStairs instance = new MinCostClimbingStairs();
        System.out.println(instance.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}

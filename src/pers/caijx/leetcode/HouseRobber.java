package pers.caijx.leetcode;

/**
 You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected
 and it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.
 * Created by Administrator on 2018/3/11/011.
 */
public class HouseRobber {

    /**
     dp[i][1] means we rob the current house and dp[i][0] means we don’t,
     1. 对这题来说，对每一家房子，在其前一家房子偷不偷的前提下，有两种可能的情况。
     2. 前一家房子被偷了，它就不能再偷了。前一家房子没被偷，它可以被偷也可以选择不偷。
     3. 可看出，每一个子问题都依赖于前一个子问题，同时每一个子问题都会产生至少一种情况（之多两种情况）。
     4. 根据上述分析，得到递推公式：
     money[i][0] = max(money[i - 1][0], money[i - 1][1])
     上述公式表示，不偷第 i 家房子，当前最大收益就是前一家房子的最大收益，前一家房子可能被偷了，也可能没有被偷。
     money[i][1] = money[i - 1][0] + nums[i]
     上述公式表示，要偷第 i 家的房子，必须在不偷第 i-1 家房子的前提下，才能加上偷第 i 家获得的收益。
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int[][] dp = new int[nums.length + 1][2];
        for (int i = 1; i <= nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = nums[i - 1] + dp[i - 1][0];
        }
        return Math.max(dp[nums.length][0], dp[nums.length][1]);
    }

    public static void main(String[] args) {
        HouseRobber houseRobber = new HouseRobber();
        System.out.println(houseRobber.rob(new int[]{2,3,4,1,9,3,2,3,3,4}));
    }
}

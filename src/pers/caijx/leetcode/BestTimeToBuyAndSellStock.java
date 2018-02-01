package pers.caijx.leetcode;

/**
 Say you have an array for which the ith element is the price of a given stock on day i.

 If you were only permitted to complete at most one transaction (ie,
 buy one and sell one share of the stock), design an algorithm to find the maximum profit.

 Example 1:
 Input: [7, 1, 5, 3, 6, 4]
 Output: 5

 max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 Example 2:
 Input: [7, 6, 4, 3, 1]
 Output: 0

 In this case, no transaction is done, i.e. max profit = 0.
 * Created by Administrator on 2018/2/1/001.
 */
public class BestTimeToBuyAndSellStock {

    /**
     We need to find out the maximum difference (which will be the maximum profit) between two numbers in the given array.
     Also, the second number (selling price) must be larger than the first one (buying price).

     In formal terms, we need to find \max(prices[j] - prices[i])max(prices[j]−prices[i]),
     for every ii and jj such that j > ij>i.
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }

    /**
     The points of interest are the peaks and valleys in the given graph.
     We need to find the largest peak following the smallest valley.
     We can maintain two variables - minprice and maxprofit corresponding to the smallest valley and maximum profit (maximum difference between selling price and minprice) obtained so far respectively.
     * @param prices
     * @return
     */
    public int maxProfit2(int prices[]) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit2(new int[]{7, 6, 4, 3, 1}));
        System.out.println(bestTimeToBuyAndSellStock.maxProfit2(new int[]{7, 1, 5, 3, 6, 4}));
    }
}

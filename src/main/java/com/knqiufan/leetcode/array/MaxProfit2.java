package com.knqiufan.leetcode.array;

/**
 * 122. 买卖股票的最佳时机 II
 * <p>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/1/04 1:34
 */
public class MaxProfit2 {
  public static void main(String[] args) {
    int[] prices = new int[]{7, 1, 5, 3, 6, 4};
    System.out.println(maxProfit(prices));
  }

  /**
   * 执行用时分布 1 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int maxProfit(int[] prices) {
    int max = 0;
    for (int i = 1; i < prices.length; i++) {
      if (prices[i] > prices[i - 1]) {
        max += prices[i] - prices[i - 1];
      }
    }
    return max;
  }
}

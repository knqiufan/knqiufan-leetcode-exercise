package com.knqiufan.leetcode.array;

/**
 * 121. 买卖股票的最佳时机
 *
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/27 0:41
 */
public class MaxProfit {
  public static void main(String[] args) {
    int[] prices = new int[]{2, 4, 1};
    System.out.println(maxProfit(prices));
  }

  /**
   * 执行用时分布 1 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int maxProfit(int[] prices) {
    int maxProfix = 0, min = prices[0];
    for (int price : prices) {
      if (price <= min) {
        min = price;
      }else if (price - min >= maxProfix) {
        maxProfix = price - min;
      }
    }
    return maxProfix;

  }
}

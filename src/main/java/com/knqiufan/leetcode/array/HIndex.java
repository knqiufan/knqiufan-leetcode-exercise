package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 274. H 指数
 * 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
 * <p>
 * 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，并且 至少 有 h 篇论文被引用次数大于等于 h 。如果 h 有多种可能的值，h 指数 是其中最大的那个。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/9 23:30
 */
public class HIndex {
  public static void main(String[] args) {
    int[] citations = new int[]{3, 0, 6, 1, 5};
    System.out.println(hIndex(citations));
  }

  private static int hIndex(int[] citations) {
    Arrays.sort(citations);
    int h = 0;
    int i = citations.length - 1;
    while (i >= 0 && citations[i] > h) {
      h++;
      i--;
    }
    return h;
  }
}

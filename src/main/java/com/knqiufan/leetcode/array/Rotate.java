package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 189. 轮转数组
 *
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/26 23:14
 */
public class Rotate {
  public static void main(String[] args) {
    int[] nums = new int[]{-1, -100, 3, 99};
    int k = 2;
    rotate(nums, k);
    System.out.println(Arrays.toString(nums));
  }

  /**
   * 执行用时分布 1 ms
   * 击败 61.85% 使用 Java 的用户
   */
  public static void rotate(int[] nums, int k) {
    int n = nums.length;
    int[] result = new int[n];
    k = k % n;
    for (int num : nums) {
      if (k == n) {
        k = 0;
      }
      result[k++] = num;
    }
    for (int i = 0; i < n; i++) {
      nums[i] = result[i];
    }
  }
}

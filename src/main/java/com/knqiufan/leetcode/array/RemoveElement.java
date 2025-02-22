package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 27. 移除元素
 *
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/23 23:01
 */
public class RemoveElement {
  public static void main(String[] args) {
    int[] nums = new int[]{3, 2, 2, 3};
    int val = 3;
    System.out.println(removeElement2(nums, val) + ", " + Arrays.toString(nums));
  }

  /**
   * 执行用时分布 0 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int removeElement(int[] nums, int val) {
    int[] ele = new int[nums.length];
    int p = 0;
    for (int num : nums) {
      if (num != val) {
        ele[p++] = num;
      }
    }
    for (int i = 0; i < ele.length; i++) {
      nums[i] = ele[i];
    }
    return p;
  }

  /**
   * 执行用时分布 0 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int removeElement2(int[] nums, int val) {
    int p = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] != val) {
        nums[p++] = nums[i];
      }
    }
    return p;
  }
}

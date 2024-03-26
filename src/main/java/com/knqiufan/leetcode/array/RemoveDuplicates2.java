package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/26 21:57
 */
public class RemoveDuplicates2 {
  public static void main(String[] args) {
    int[] nums = new int[]{1, 1, 1, 2, 2, 3};
    System.out.println(removeDuplicates(nums) + ": " + Arrays.toString(nums));
  }

  /**
   * 执行用时分布 0 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int removeDuplicates(int[] nums) {
    int i = 0;
    for (int num : nums) {
      if (i < 2 || nums[i - 2] < num) {
        nums[i++] = num;
      }
    }
    return i;
  }
}

package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 169. 多数元素
 *
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/25 23:04
 */
public class MajorityElement {

  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 1, 1, 1, 2, 2, 1};
    System.out.println(majorityElement(nums) + ": " + Arrays.toString(nums));
  }

  public static int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}

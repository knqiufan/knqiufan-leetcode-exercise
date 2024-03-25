package com.knqiufan.leetcode.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目：
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/22 23:46
 */
public class NumberSum {
  public static void main(String[] args) {
    int[] nums = new int[]{2, 2, 1};
    int target = 4;
    System.out.println(Arrays.toString(twoSum(nums, target)));
    System.out.println(Arrays.toString(twoSum2(nums, target)));
    System.out.println(Arrays.toString(twoSum3(nums, target)));
    System.out.println(Arrays.toString(twoSum4(nums, target)));
  }

  /**
   * 执行用时 115 ms（击败 5.02% 使用 Java 的用户）
   */
  public static int[] twoSum(int[] nums, int target) {
    int[] result = new int[2];
    for (int i = 0; i < nums.length; i++) {
      result[0] = i;
      for (int j = 0; j < nums.length; j++) {
        if (i == j) {
          continue;
        }
        if (nums[i] + nums[j] == target) {
          result[1] = j;
          break;
        }
      }
      if (result[1] != 0) {
        break;
      }
    }
    return result;
  }

  /**
   * 暴力枚举 执行用时分布 55 ms
   * 击败 16.10% 使用 Java 的用户
   */
  public static int[] twoSum2(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{0, 0};
  }

  /**
   * 哈希表
   * 执行用时分布 2 ms
   * 击败 97.84% 使用 Java 的用户
   * @param nums
   * @param target
   * @return
   */
  public static int[] twoSum3(int[] nums, int target) {
    Map<Integer, Integer> hashtable = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      if (hashtable.containsKey(target - nums[i])) {
        return new int[]{hashtable.get(target - nums[i]), i};
      }
      hashtable.put(nums[i], i);
    }
    return new int[0];
  }

  /**
   * 哈希表，升级版
   * 执行用时分布 0 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int[] twoSum4(int[] nums, int target) {
    Map<Integer, Integer> hashtable = new HashMap<>();
    for (int i = 0; i < nums.length; ++i) {
      int j = nums.length - i - 1;
      if (i == j) {
        if (hashtable.containsKey(target - nums[i])) {
          return new int[]{hashtable.get(target - nums[i]), i};
        }
      }
      int numi = target - nums[i];
      int numj = target - nums[j];
      if (numj + numi == target) {
        return new int[]{i, j};
      }
      if (hashtable.containsKey(numi)) {
        return new int[]{hashtable.get(numi), i};
      }
      if (hashtable.containsKey(numj)) {
        return new int[]{hashtable.get(numj), j};
      }
      hashtable.put(nums[i], i);
      hashtable.put(nums[j], j);
    }
    return new int[0];
  }
}

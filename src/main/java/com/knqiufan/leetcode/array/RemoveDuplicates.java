package com.knqiufan.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 26. 删除有序数组中的重复项
 *
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/25 22:10
 */
public class RemoveDuplicates {
  public static void main(String[] args) {
    int[] nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    System.out.println(removeDuplicates2(nums) + ": " + Arrays.toString(nums));
  }

  /**
   * 转为 List 遍历赋值，效率低且占用内存大
   */
  public static int removeDuplicates(int[] nums) {
    int len = nums.length;
    List<Integer> result = new ArrayList<>(len);
    for (int i = 0; i < len; i++) {
      if(result.contains(nums[i])) {
        continue;
      }
      result.add(nums[i]);
    }
    for (int i = 0; i < result.size(); i++) {
      nums[i] = result.get(i);
    }
    return result.size();
  }

  /**
   * 双指针
   *
   * 执行用时分布 0  ms
   * 击败 100.00% 使用 Java 的用户
   *
   * 消耗内存分布 43.77 MB
   * 击败 73.47% 使用 Java 的用户
   */
  public static int removeDuplicates2(int[] nums) {
    int p2 = 0;
    for (int i = 0; i < nums.length; i++) {
      if(nums[i] != nums[p2]) {
        nums[++p2] = nums[i];
      }

    }
    return p2 + 1;
  }

}

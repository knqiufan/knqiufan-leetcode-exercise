package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 *
 * 给你两个按 非递减顺序 排列的整数数组 nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2024/3/23 1:35
 */
public class MergedOrderedArray {
  public static void main(String[] args) {
    int[] nums1 = new int[]{4, 5, 6, 0, 0, 0};
    int[] nums2 = new int[]{1, 2, 3};
    int m = 3;
    int n = 3;
    // System.out.println(Arrays.toString(merge(nums1, m, nums2, n)));
    System.out.println(Arrays.toString(merge2(nums1, m, nums2, n)));
  }

  /**
   * 直接合并后排序
   * 执行用时分布 1 ms
   * 击败 28.39% 使用 Java 的用户
   */
  public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    System.arraycopy(nums2, 0, nums1, m, n);
    int temp = 0;
    for (int i = 0; i < nums1.length - 1; i++) {
      for (int j = 0; j < nums1.length - i - 1; j++) {
        if (nums1[j] > nums1[j + 1]) {
          temp = nums1[j];
          nums1[j] = nums1[j + 1];
          nums1[j + 1] = temp;
        }
      }
    }
    return nums1;
  }

  /**
   * 双指针
   * 执行用时分布 0 ms
   * 击败 100.00% 使用 Java 的用户
   */
  public static int[] merge2(int[] nums1, int m, int[] nums2, int n) {
    // 设置 nums1 的头指针和 nums2 的头指针
    int p1 = 0, p2 = 0;
    int[] sorted = new int[m + n];
    int cur;
    while (p1 < m || p2 < n) {
      if (p1 == m) {
        cur = nums2[p2++];
      } else if (p2 == n) {
        cur = nums1[p1++];
      } else if (nums1[p1] < nums2[p2]) {
        cur = nums1[p1++];
      } else {
        cur = nums2[p2++];
      }
      sorted[p1 + p2 - 1] = cur;
    }
    // System.arraycopy 占用内存更高
    // System.arraycopy(sorted, 0, nums1, 0, nums1.length);
    for (int i = 0; i < sorted.length; i++) {
      nums1[i] = sorted[i];
    }
    return nums1;
  }
}

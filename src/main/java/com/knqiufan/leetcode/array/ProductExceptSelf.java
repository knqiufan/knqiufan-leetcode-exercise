package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 238. 除自身以外数组的乘积
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * <p>
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * <p>
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/11 11:47
 */
public class ProductExceptSelf {
  public static void main(String[] args) {
    int[] nums = new int[]{-1, 1, 0, -3, 3};
    System.out.println(Arrays.toString(productExceptSelf(nums)));
  }

  /**
   * 双指针方法。求解前缀和后缀，总和只遍历一次
   *
   * @param nums
   * @return
   */
  public static int[] productExceptSelf(int[] nums) {
    int n = nums.length;
    int[] ans = new int[n];
    // 初始化ans都为1
    for (int i = 0; i < n; i++) {
      ans[i] = 1;
    }
    // 左侧
    int L = 1;
    for (int i = 0; i < n; i++) {
      ans[i] *= L;
      L *= nums[i];
    }
    // 右侧
    int R = 1;
    for (int i = n - 1; i >= 0; i--) {
      ans[i] *= R;
      R *= nums[i];
    }
    return ans;
    // int[] answer = new int[nums.length];
    // for (int i = 0; i < nums.length; i++) {
    //   answer[i] = a(nums, i);
    // }
    // return answer;
  }

  // 两个循环不符合空间复杂度为 O(n) 的要求
  // private static int a(int[] nums, int current) {
  //   int result = 1;
  //   for (int i = 0; i < nums.length; i++) {
  //     if(current == i) {
  //       continue;
  //     }
  //     result = result * nums[i];
  //   }
  //   return result;
  // }
}

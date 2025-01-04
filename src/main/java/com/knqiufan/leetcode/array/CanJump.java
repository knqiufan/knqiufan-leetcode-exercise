package com.knqiufan.leetcode.array;

/**
 * 55. 跳跃游戏
 * 给你一个非负整数数组 nums ，你最初位于数组的 第一个下标 。数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标，如果可以，返回 true ；否则，返回 false 。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/4 15:59
 */
public class CanJump {
  public static void main(String[] args) {
    int[] nums = new int[]{2, 3, 1, 1, 4};
    System.out.println(canJump(nums));
  }

  /**
   * 贪心算法
   * 解题思路：遍历数组，使用一个变量记录当前能够到达的最远距离
   * 若某个位置可达，即到达的最远距离小于或者等于最远距离，则更新更新变量
   * 若能够到达的最远位置大于或等于最后一个位置的索引，返回 true
   * 遍历结束没有到达最后一个索引，返回 false
   *
   * @param nums 源数据
   * @return 是否可达
   */
  public static boolean canJump(int[] nums) {
    int max = 0;
    for (int i = 0; i < nums.length; i++) {
      if (i > max) return false;
      max = Math.max(max, nums[i] + i);
    }
    return true;
  }
}

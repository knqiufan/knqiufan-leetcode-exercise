package com.knqiufan.leetcode.array;

/**
 * 45. 跳跃游戏 II
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * - 0 <= j <= nums[i]
 * - i + j < n
 * 返回到达 nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/5 21:18
 */
public class CanJump2 {

  public static void main(String[] args) {
    int[] nums = new int[]{1, 2, 1, 1, 1};
    System.out.println(jump(nums));
  }

  private static int jump(int[] nums) {
    int max = 0;
    int len = nums.length;
    int curr = 0;
    int count = 0;
    if (len <= 1) return 0;
    for (int i = 0; i < len; i++) {
      max = Math.max(max, nums[i] + i);
      if (curr == i) {
        count++;
        curr = max;
      }
      if (curr >= len - 1) {
        break;
      }
    }
    return count;
  }
}

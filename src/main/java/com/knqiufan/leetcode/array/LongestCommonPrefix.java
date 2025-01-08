package com.knqiufan.leetcode.array;

import java.util.Arrays;

/**
 * 14. 最长公共前缀
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/8 22:57
 */
public class LongestCommonPrefix {

  public static void main(String[] args) {
    String[] strs = new String[]{"dog", "dios", "dogg"};
    System.out.println(longestCommonPrefix(strs));
  }

  /**
   * 8 ms 击败 9.23%
   *
   * @param strs 数组
   * @return 最长前缀
   */
  private static String longestCommonPrefix(String[] strs) {
    String prefix = "";
    String str = strs[0];
    for (int i = 0; i < str.length(); i++) {
      prefix += str.charAt(i);
      boolean isStartsWith = true;
      for (String s : strs) {
        if (!s.startsWith(prefix)) {
          isStartsWith = false;
          break;
        }
      }
      if (!isStartsWith) {
        prefix = prefix.substring(0, prefix.length() - 1);
        break;
      }
    }
    return prefix;
  }
}

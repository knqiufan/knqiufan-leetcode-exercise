package com.knqiufan.leetcode.string;

/**
 * 151. 反转字符串中的单词
 * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
 * <p>
 * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
 * <p>
 * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
 * <p>
 * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/12 22:46
 */
public class ReverseWords {
  public static void main(String[] args) {
    String str = "  hello world  ";
    System.out.println(reverseWords(str));
  }

  /**
   * 正则表达式，将字符串多个空格转换为一个空格，并去除前后空格
   * 用 split 分割为数组，并将数组倒序排序
   *
   * @param s 字符串
   * @return 倒序字符串
   */
  public static String reverseWords(String s) {
    String s1 = s.replaceAll("\\s+", " ").trim();
    String[] split = s1.split(" ");
    String[] result = new String[split.length];
    for (int i = split.length - 1; i >= 0; i--) {
      result[split.length - 1 - i] = split[i];
    }
    return String.join(" ", result);
  }
}

package com.knqiufan.leetcode.string;

/**
 * 58. 最后一个单词的长度
 * 给你一个字符串 s，由若干单词组成，单词前后用一些空格字符隔开。返回字符串中 最后一个 单词的长度。
 * <p>
 * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串
 * 。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/8 22:47
 */
public class LengthOfLastWord {
  public static void main(String[] args) {
    String str = "hello world dfwg sdw  a ";
    System.out.println(lengthOfLastWord(str));
  }

  /**
   * 1 ms 击败 36.23%
   *
   * @param str 字符串
   * @return 最后一个单词长度
   */
  private static int lengthOfLastWord(String str) {
    String[] strArray = str.trim().split(" ");
    return strArray[strArray.length - 1].length();
  }
}

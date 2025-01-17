package com.knqiufan.leetcode.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 6. Z 字形变换
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 * 比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * <p>
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/17 22:34
 */
public class Convert {

  public static void main(String[] args) {
    String s = "PAYPALISHIRING";
    int numRows = 3;
    System.out.println(convert(s, numRows));
  }

  public static String convert(String s, int numRows) {
    if (numRows == 1) return s;

    List<StringBuilder> rows = new ArrayList<>();
    for (int i = 0; i < Math.min(numRows, s.length()); i++)
      rows.add(new StringBuilder());

    int curRow = 0;
    boolean goingDown = false;

    for (char c : s.toCharArray()) {
      rows.get(curRow).append(c);
      if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
      curRow += goingDown ? 1 : -1;
    }

    StringBuilder ret = new StringBuilder();
    for (StringBuilder row : rows) ret.append(row);
    return ret.toString();
  }
}

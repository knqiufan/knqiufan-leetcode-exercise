package com.knqiufan.leetcode.string;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. 罗马数字转整数
 * 罗马数字包含以下七种字符: I， V， X， L，C，D 和 M。
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1 。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 * <p>
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 * <p>
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个罗马数字，将其转换成整数。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/6 22:59
 */
public class RomanToInt {

  public static void main(String[] args) {
    String s = "IX";
    System.out.println(romanToInt2(s));
  }
  static Map<String, Integer> rule = new HashMap<>() {{
    put("I", 1);
    put("V", 5);
    put("X", 10);
    put("L", 50);
    put("C", 100);
    put("D", 500);
    put("M", 1000);
  }};
  /**
   * 当前位置的元素比下个位置的元素小，就减去当前值，否则加上当前值
   * 击败 27.64%
   *
   * @param s 罗马数字
   * @return 整数
   */
  private static int romanToInt2(String s) {
    int sum = 0;
    for (int i = 0; i < s.length(); i++) {
      int value = rule.get(String.valueOf(s.charAt(i)));
      if (i < s.length() - 1 && value < rule.get(String.valueOf(s.charAt(i + 1)))) {
        sum -= value;
      } else {
        sum += value;
      }
    }
    return sum;
  }

  /**
   * 很慢，击败 9.7%
   *
   * @param s 罗马数字
   * @return 整数
   */
  private static int romanToInt(String s) {
    Map<String, Integer> spatialRule = new HashMap<>() {{
      put("IV", 4);
      put("IX", 9);
      put("XL", 40);
      put("XC", 90);
      put("CD", 400);
      put("CM", 900);
    }};
    int sum = 0;
    // 处理特殊情况
    for (String key : spatialRule.keySet()) {
      if (s.contains(key)) {
        s = s.substring(0, s.indexOf(key)) + s.substring(s.indexOf(key) + 2);
        sum += spatialRule.get(key);
      }
    }
    for (int i = 0; i < s.length(); i++) {
      sum += rule.get(String.valueOf(s.charAt(i)));
    }
    return sum;
  }
}

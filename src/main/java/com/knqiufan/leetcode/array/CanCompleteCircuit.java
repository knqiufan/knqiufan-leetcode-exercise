package com.knqiufan.leetcode.array;

import java.util.Scanner;

/**
 * 134. 加油站
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * <p>
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * <p>
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * @author knqiufan
 * @version 1.0.0
 * @date 2025/1/10 23:41
 */
public class CanCompleteCircuit {
  public static void main(String[] args) {
    int[] gas = new int[]{5,1,2,3,4};
    int[] cost = new int[]{4,4,1,5,1};
    System.out.println(canCompleteCircuit(gas, cost));
  }

  public static int canCompleteCircuit(int[] gas, int[] cost) {
    int begin = -1;
    // 计算 gas 和 cost 的 sum
    int sumGas = sum(gas);
    int sumCost = sum(cost);
    if (sumCost > sumGas) {
      return -1;
    }
    // 递归
    return b(gas, cost, begin, 0);
  }

  private static int b(int[] gas, int[] cost, int begin, int i) {
    if (i == gas.length) {
      return begin;
    }
    int next;
    int sheng = 0;
    sheng += gas[i];
    next = a(sheng, cost);
    if (next == -1) {
      b(gas, cost, begin, i + 1);
    } else if (begin == -1) {
      begin = next;
    } else {
      b(gas, cost, begin, next);
    }
    return begin;
  }

  private static int a(int sheng, int[] cost) {
    for (int i = 0; i < cost.length; i++) {
      if (sheng >= cost[i]) {
        return i;
      }
    }
    return -1;
  }

  private static int sum(int[] arr) {
    int sum = 0;
    for (int i : arr) {
      sum += i;
    }
    return sum;
  }
}

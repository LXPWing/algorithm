package 算法基础.基础算法.双指针;

import java.util.*;
import java.io.*;

/**
 * 给定一个长度为 n 的整数序列，请找出最长的不包含重复的数的连续区间，输出它的长度。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 第二行包含 n 个整数（均在 0∼105 范围内），表示整数序列。
 *
 * 输出格式
 * 共一行，包含一个整数，表示最长的不包含重复的数的连续区间的长度。
 *
 * 数据范围
 * 1≤n≤105
 * 输入样例：
 * 5
 * 1 2 2 3 5
 * 输出样例：
 * 3
 */
public class Main{
    static int[] m = new int[100010];
    public static void main(String[] args){
        int max = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i=0;i<n;i++) nums[i] = sc.nextInt();

        for(int i=0,j=0;i<n && j<n;j++) {
            m[nums[j]]++;
            while(i < j && m[nums[j]] > 1) {
                m[nums[i]]--;
                i++;
            }
            max= Math.max(max, j - i + 1);
        }

        System.out.println(max);
    }
}
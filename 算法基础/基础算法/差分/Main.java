package 算法基础.基础算法.差分;

import java.util.*;
import java.io.*;

/**
 * 输入一个长度为 n 的整数序列。
 *
 * 接下来输入 m 个操作，每个操作包含三个整数 l,r,c，表示将序列中 [l,r] 之间的每个数加上 c。
 *
 * 请你输出进行完所有操作后的序列。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 第二行包含 n 个整数，表示整数序列。
 *
 * 接下来 m 行，每行包含三个整数 l，r，c，表示一个操作。
 *
 * 输出格式
 * 共一行，包含 n 个整数，表示最终序列。
 *
 * 数据范围
 * 1≤n,m≤100000,
 * 1≤l≤r≤n,
 * −1000≤c≤1000,
 * −1000≤整数序列中元素的值≤1000
 * 输入样例：
 * 6 3
 * 1 2 2 1 2 1
 * 1 3 1
 * 3 5 1
 * 1 6 1
 * 输出样例：
 * 3 4 5 3 4 2
 */
public class Main{
    static int[] b = new int[100010];
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n+1];
        int q = sc.nextInt();
        for(int i=1;i<=n;i++) nums[i] = sc.nextInt();
        for(int i=1;i<=n;i++) change(i,i,nums[i]);
        while(q-- != 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            int k = sc.nextInt();
            change(l,r,k);
        }
        
        for(int i=1;i<=n;i++){
            b[i] += b[i - 1];
        }
        for(int i=1;i<=n;i++){
            System.out.print(b[i] + " ");
        }
    }
    
    static void change(int l,int r,int k){
        b[l] += k;
        b[r + 1] -= k;
    }
}
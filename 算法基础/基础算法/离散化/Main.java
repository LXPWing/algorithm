package 算法基础.基础算法.离散化;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * （离散化用于值域大，个数少情况，具体实现借助二分思想）
 *
 * 假定有一个无限长的数轴，数轴上每个坐标上的数都是 0。
 *
 * 现在，我们首先进行 n 次操作，每次操作将某一位置 x 上的数加 c。
 *
 * 接下来，进行 m 次询问，每个询问包含两个整数 l 和 r，你需要求出在区间 [l,r] 之间的所有数的和。
 *
 * 输入格式
 * 第一行包含两个整数 n 和 m。
 *
 * 接下来 n 行，每行包含两个整数 x 和 c。
 *
 * 再接下来 m 行，每行包含两个整数 l 和 r。
 *
 * 输出格式
 * 共 m 行，每行输出一个询问中所求的区间内数字和。
 *
 * 数据范围
 * −109≤x≤109,
 * 1≤n,m≤105,
 * −109≤l≤r≤109,
 * −10000≤c≤10000
 * 输入样例：
 * 3 3
 * 1 2
 * 3 6
 * 7 5
 * 1 3
 * 4 6
 * 7 8
 * 输出样例：
 * 8
 * 0
 * 5
 *
 * 1. 记录需要离散化值
 * 2. 对需要离散化的值去重
 */
public class Main {
    static int n, m;
    static TreeSet<Integer> set = new TreeSet();
    static ArrayList<Integer> list = new ArrayList<>();
    int N = 300010;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        while(n -- != 0){

        }

        while(m-- != 0){

        }
    }
}

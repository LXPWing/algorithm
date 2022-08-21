package 算法基础.搜索与图论.最短路算法.floyd;

import java.util.*;
import java.io.*;

/**
 * （Floyd用于无负权多源最短路，核心思想通过动态规划计算最短路）
 *
 * 给定一个 n 个点 m 条边的有向图，图中可能存在重边和自环，边权可能为负数。
 *
 * 再给定 k 个询问，每个询问包含两个整数 x 和 y，表示查询从点 x 到点 y 的最短距离，如果路径不存在，则输出 impossible。
 *
 * 数据保证图中不存在负权回路。
 *
 * 输入格式
 * 第一行包含三个整数 n,m,k。
 *
 * 接下来 m 行，每行包含三个整数 x,y,z，表示存在一条从点 x 到点 y 的有向边，边长为 z。
 *
 * 接下来 k 行，每行包含两个整数 x,y，表示询问点 x 到点 y 的最短距离。
 *
 * 输出格式
 * 共 k 行，每行输出一个整数，表示询问的结果，若询问两点间不存在路径，则输出 impossible。
 *
 * 数据范围
 * 1≤n≤200,
 * 1≤k≤n2
 * 1≤m≤20000,
 * 图中涉及边长绝对值均不超过 10000。
 *
 * 输入样例：
 * 3 3 2
 * 1 2 1
 * 2 3 2
 * 1 3 1
 * 2 1
 * 1 3
 * 输出样例：
 * impossible
 * 1
 */
public class Main {
    static int N = 210;
    static int[][] d = new int[N][N];
    static int n;
    static int m;
    static int k;
    static int INF = 0x3f3f3f3f;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();
        
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(i == j) d[i][j] = 0;
                else d[i][j] = INF;
            }
        }
        
        while(m-- != 0) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int z = sc.nextInt();
            
            d[x][y] = Math.min(d[x][y], z);
        }
        
        floyd();
        
        while(k-- != 0) {
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            if(d[l][r] > INF/2) System.out.println("impossible");
            else System.out.println(d[l][r]);
        }
    }
    
    static void floyd() {
        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
                }
            }
        }
    }
}
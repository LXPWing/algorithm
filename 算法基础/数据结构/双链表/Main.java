package 算法基础.数据结构.双链表;

import java.util.*;
import java.io.*;

/**
 * 实现一个双链表，双链表初始为空，支持 5
 *  种操作：
 *
 * 在最左侧插入一个数；
 * 在最右侧插入一个数；
 * 将第 k
 *  个插入的数删除；
 * 在第 k
 *  个插入的数左侧插入一个数；
 * 在第 k
 *  个插入的数右侧插入一个数
 * 现在要对该链表进行 M
 *  次操作，进行完所有操作后，从左到右输出整个链表。
 *
 * 注意:题目中第 k
 *  个插入的数并不是指当前链表的第 k
 *  个数。例如操作过程中一共插入了 n
 *  个数，则按照插入的时间顺序，这 n
 *  个数依次为：第 1
 *  个插入的数，第 2
 *  个插入的数，…第 n
 *  个插入的数。
 *
 * 输入格式
 *
 * 第一行包含整数 M
 * ，表示操作次数。
 *
 * 接下来 M
 *  行，每行包含一个操作命令，操作命令可能为以下几种：
 *
 * L x，表示在链表的最左端插入数 x
 * 。
 * R x，表示在链表的最右端插入数 x
 * 。
 * D k，表示将第 k
 *  个插入的数删除。
 * IL k x，表示在第 k
 *  个插入的数左侧插入一个数。
 * IR k x，表示在第 k
 *  个插入的数右侧插入一个数。
 * 输出格式
 *
 * 共一行，将整个链表从左到右输出。
 *
 * 数据范围
 *
 * 1≤M≤100000
 *
 * 所有操作保证合法。
 *
 * 输入样例：
 *
 * 10
 * R 7
 * D 1
 * L 3
 * IL 2 10
 * D 3
 * IL 2 7
 * L 8
 * R 9
 * IL 4 7
 * IR 2 2
 * 输出样例：
 *
 * 8 7 7 3 2 9
 */
public class Main{
    static int N = 100010;
    static int[] l = new int[N];
    static int[] r = new int[N];
    static int[] e = new int[N];
    static int idx = 2;
    
    static void init(){
        r[0] = 1;
        l[1] = 0;
    }
   
    static void add (int a, int b) {
        e[idx] = b;
        l[idx] = a;
        r[idx] = r[a];
        l[r[a]] = idx;
        r[a] = idx++;
        
    }
    
    static void del(int a) {
        r[l[a]] = r[a];
        l[r[a]] = l[a];
    }
    
    public static void main(String[] arg){
        Scanner scan = new Scanner(System.in);
        int m = scan.nextInt();

        init();

        while(m -- > 0){
            String s = scan.next();
            char op = s.charAt(0);
            if(op == 'L'){
                int x = scan.nextInt();
                add(0,x);
            }else if(op == 'R'){
                int x = scan.nextInt();
                add(l[1],x);
            }else if(op == 'D'){
                int k = scan.nextInt();
                del(k + 1);
            }else if(s.equals("IR")){
                int k  = scan.nextInt();
                int x = scan.nextInt();
                add(k + 1,x);
            }else {
                int k = scan.nextInt();
                int x = scan.nextInt();
                add(l[k+1],x);
            }
        }
       for(int i = r[0];i != 1; i= r[i]){
            System.out.print(e[i]  + " ");
       }
    }
}
package 算法基础.数据结构.单链表;

import java.util.*;
import java.io.*;

/**
 * 实现一个单链表，链表初始为空，支持三种操作：
 *
 * 向链表头插入一个数；
 * 删除第 k
 *  个插入的数后面的数；
 * 在第 k
 *  个插入的数后插入一个数。
 * 现在要对该链表进行 M
 *  次操作，进行完所有操作后，从头到尾输出整个链表。
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
 * H x，表示向链表头插入一个数 x
 * 。
 * D k，表示删除第 k
 *  个插入的数后面的数（当 k
 *  为 0
 *  时，表示删除头结点）。
 * I k x，表示在第 k
 *  个插入的数后面插入一个数 x
 * （此操作中 k
 *  均大于 0
 * ）。
 * 输出格式
 *
 * 共一行，将整个链表从头到尾输出。
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
 * H 9
 * I 1 1
 * D 1
 * D 0
 * H 6
 * I 3 6
 * I 4 5
 * I 4 5
 * I 3 4
 * D 6
 * 输出样例：
 *
 * 6 4 6 5
 */
public class Main {
    static int N = 100010;
    static int e[] = new int[N];
    static int ne[] = new int[N];
    //static int h[] = new int[N];
    static int idx = 0;
    static int head = -1;
    static void add(int a, int b){
        e[idx] = b;
        ne[idx] = ne[a];
        ne[a] = idx++;
    }

    static void delete(int a) {
        ne[a] = ne[ne[a]];
    }

    static void addHead(int a) {
        e[idx] = a;
        ne[idx] = head;
        head = idx;
        idx++;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //Arrays.fill(h, -1);
        int n = sc.nextInt();
        while(n-- != 0) {
            String op = sc.next();
            if(op.equals("H")) {
                int l = sc.nextInt();
                addHead(l);
            }

            if(op.equals("D")) {
                int l = sc.nextInt();
                if (l == 0)
                    head = ne[head];
                else delete(l-1);
            }

            if(op.equals("I")) {
                int l = sc.nextInt();
                int r = sc.nextInt();
                add(l-1,r);
            }
        }

        for(int i=head;i!=-1;i=ne[i]){
            System.out.print(e[i] + " ");
        }
    }
}
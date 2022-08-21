package 算法基础.基础算法.区间合并;

import java.util.*;

/**
 * （需要先对区间排序，然后list存放已经处理的区间，用list的最后一个元素与代处理区间比较）
 * 给定 n 个区间 [li,ri]，要求合并所有有交集的区间。
 *
 * 注意如果在端点处相交，也算有交集。
 *
 * 输出合并完成后的区间个数。
 *
 * 例如：[1,3] 和 [2,6] 可以合并为一个区间 [1,6]。
 *
 * 输入格式
 * 第一行包含整数 n。
 *
 * 接下来 n 行，每行包含两个整数 l 和 r。
 *
 * 输出格式
 * 共一行，包含一个整数，表示合并区间完成后的区间个数。
 *
 * 数据范围
 * 1≤n≤100000,
 * −109≤li≤ri≤109
 * 输入样例：
 * 5
 * 1 2
 * 2 4
 * 5 6
 * 7 8
 * 7 9
 * 输出样例：
 * 3
 */
public class Main {
    static int n;
    static int[][] nums;
    static int idx = 0;
    static List<List<Integer>> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        nums = new int[n][2];
        int t = n;
        while(t-- != 0) {
            nums[idx][0] = sc.nextInt();
            nums[idx][1] = sc.nextInt();
            idx++;
        }

        Arrays.sort(nums, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            else return o1[0] - o2[0];
        });

        // list存放已经处理的区间
        for(int i=0;i<n;i++){
            int l = nums[i][0];
            int r = nums[i][1];
            if(list.size() > 0) {
                List<Integer> li = list.get(list.size() - 1);
                if(l > li.get(1)) {
                    List<Integer> path = new ArrayList<>();
                    path.add(l);
                    path.add(r);
                    list.add(path);
                } else {
                    if(r > li.get(1)) {
                        li.set(1, r);
                    }
                }
            } else {
                List<Integer> path = new ArrayList<>();
                path.add(l);
                path.add(r);
                list.add(path);
            }
        }

        System.out.println(list.size());
    }
}

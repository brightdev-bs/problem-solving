package BFS_DFS;

import java.util.*;

public class Q1260 {

    public static int[] ch;
    public static int[] ch2;
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();

        ch = new int[n + 1];
        ch2 = new int[n + 1];

        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            list.get(v1).add(v2);
            list.get(v2).add(v1);
        }

        for(int i = 0; i <= n; i++) {
            Collections.sort(list.get(i));
        }

        DFS(s);
        System.out.println();
        BFS(s);
    }

    public static void DFS(int s) {
        System.out.print(s + " ");
        ch[s] = 1;
        for (int now : list.get(s)) {
            if(ch[now] != 1) {
                DFS(now);
            }
        }
    }

    public static void BFS(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        ch2[s] = 1;
        while(!queue.isEmpty()) {
            Integer current = queue.poll();
            System.out.print(current + " ");
            for (Integer integer : list.get(current)) {
                if(ch2[integer] != 1) {
                    ch2[integer] = 1;
                    queue.add(integer);
                }
            }
        }
    }
}

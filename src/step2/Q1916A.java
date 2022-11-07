package step2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

// 다시풀기
public class Q1916A {

    static int[] ch;

    public static class Edge implements Comparable<Edge> {
        int v, c;

        public Edge(int v, int c) {
            this.v = v;
            this.c = c;
        }

        @Override
        public int compareTo(Edge o) {
            return this.c - o.c;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n + 1];
        Arrays.fill(ch, Integer.MAX_VALUE);

        ArrayList<ArrayList<Edge>> list = new ArrayList<ArrayList<Edge>>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int v = sc.nextInt();
            int v2 = sc.nextInt();
            int c = sc.nextInt();
            list.get(v).add(new Edge(v2, c));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(start, 0));
        ch[start] = 0;
        while(!pq.isEmpty()) {
            Edge edge = pq.poll();
            int now = edge.v;
            int nowCost = edge.c;

            if(nowCost > ch[now]) continue;

            for (Edge next : list.get(now)) {
                if(ch[next.v] > next.c + nowCost) {
                    ch[next.v] = next.c + nowCost;
                    pq.add(new Edge(next.v, next.c + nowCost));
                }
            }
        }

        System.out.println(ch[end]);
    }
}

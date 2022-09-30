package step2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Q1197 {

    static int[] unf;

    public static class Edge implements Comparable<Edge> {
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int v = sc.nextInt(); // 정점의 개수
        int e = sc.nextInt(); // 간선의 개수

        unf = new int[v+1];
        for(int i = 0; i <= v; i++) {
            unf[i] = i;
        }
        ArrayList<Edge> list = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(a, b, c));
        }

        Collections.sort(list);

        int answer = 0;
        for (Edge edge : list) {
            int v1 = find(edge.v1);
            int v2 = find(edge.v2);
            if(v1 != v2) {
                answer += edge.cost;
                union(v1, v2);
            }
        }
        System.out.println(answer);
    }

    public static int find(int v){
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
}

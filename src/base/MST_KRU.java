package base;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class MST_KRU {

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

        int v = sc.nextInt();
        int e = sc.nextInt();

        unf = new int[v + 1];
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

        Collections.sort(list); // cost를 기준으로 정렬

        int answer = 0;
        int cnt = 0;
        for (Edge edge : list) {
            if(cnt == v-1) break;
            int fv1 = find(edge.v1);
            int fv2 = find(edge.v2);
            if(fv1 != fv2)  {
                answer += edge.cost;
                union(edge.v1, edge.v2);
                cnt++;
            }
        }

        System.out.println(answer);

    }

    public static int find(int a) {
        if(unf[a] == a) return a;
        else return unf[a] = find(unf[a]);

    }

    public static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if(fa != fb) unf[fa] = fb;
    }
}

package bible;

import java.util.*;

public class MinTree {

    public static int[] unf;

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

        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Edge(v1, v2, c));
        }

        unf = new int[v+1];
        for(int i = 0; i <= v; i++) {
            unf[i] = i;
        }

        Collections.sort(list);

        int answer = 0;
        for (Edge edge : list) {
            int v1 = edge.v1;
            int v2 = edge.v2;

            int fv = find(v1);
            int fv2 = find(v2);

            if(fv != fv2) {
                answer += edge.cost;
                union(v1, v2);
            }
        }

        System.out.println(answer);
    }

    public static int find(int v) {
        if(unf[v] == v) return v;
        else return unf[v] = find(unf[v]);
    }

    public static void union(int v1, int v2) {
        int fa = find(v1);
        int fb = find(v2);
        if(fa != fb) unf[fa] = fb;
    }
}

package bible;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Prim {

    private static boolean[] ch;

    public static class Edge implements Comparable<Edge> {
        int v, cost;

        public Edge(int v, int cost) {
            this.v = v;
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

        ch = new boolean[v + 1];

        ArrayList<ArrayList<Edge>> list = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            int c = sc.nextInt();
            list.get(v1).add(new Edge(v2, c));
            list.get(v2).add(new Edge(v1, c));
        }

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(1, 0));

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge current = pq.poll();

            if (!ch[current.v]) {
                answer += current.cost;
                ch[current.v] = true;

                for (Edge edge : list.get(current.v)) {
                    pq.add(edge);
                }
            }
        }

        System.out.println(answer);
    }
}

package BFS_DFS;

import java.util.*;

public class Q2606 {

    public static class Edge {
        int v1, v2;

        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int c = sc.nextInt(); // 컴퓨터 수
        int e = sc.nextInt(); // 간선 수

        List<Edge> edges = new ArrayList<>();
        for(int i = 0; i < e; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            edges.add(new Edge(v1, v2));
            edges.add(new Edge(v2, v1));
        }

        boolean[] ch = new boolean[c + 1];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        ch[1] = true;
        int count = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i = 0; i < len; i++) {
                Integer current = queue.poll();
                for (Edge edge : edges) {
                    if(edge.v1 == current && !ch[edge.v2]) {
                        ch[edge.v2] = true;
                        queue.add(edge.v2);
                    }
                }
            }
        }

        for (boolean b : ch) {
            if(b) count++;
        }

        System.out.println(count - 1);
    }
}

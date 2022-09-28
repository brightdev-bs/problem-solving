package base;

import java.util.*;


public class Dijkstra {

    static int[] dis;

    static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 정점의 수
        int m = sc.nextInt(); // 간선의 수

        ArrayList<ArrayList<Node>>list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList());
        }

        for(int i = 0; i < m; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int cost = sc.nextInt();
            list.get(from).add(new Node(to, cost));
        }

        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(1, 0));
        dis[1] = 0;
        while(!pq.isEmpty()) {
            Node node = pq.poll();
            int now = node.to;
            int nowCost = node.cost;
            if(nowCost > dis[now]) continue;
            for (Node tmp : list.get(now)) {
                if(dis[tmp.to] > tmp.cost + nowCost) {
                    dis[tmp.to] = tmp.cost + nowCost;
                    pq.offer(new Node(tmp.to, nowCost + tmp.cost));
                }
            }
        }

        for(int i = 2; i <= n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}

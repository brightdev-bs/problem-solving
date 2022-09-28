package step2;


import java.util.*;

public class Q1916 {

    static int[] dis;

    public static class Node implements Comparable<Node>{
        int now, cost;

        public Node(int now, int cost) {
            this.now = now;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return this.cost - o.cost;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // 도시의 개수
        int m = sc.nextInt(); // 버스의 수

        // ArrayList를 초기화한다.
        ArrayList<ArrayList<Node>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        // 입력 받기
        for(int i = 1; i <= m; i++) {
            int s = sc.nextInt(); // 출발지
            int d = sc.nextInt(); // 도착지
            int c = sc.nextInt(); // 비용
            list.get(s).add(new Node(d, c));
        }


        dis = new int[n + 1];
        Arrays.fill(dis, Integer.MAX_VALUE);

        int start = sc.nextInt();
        int end = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작점을 우선순위 큐에 넣는다.
        pq.add(new Node(start, 0));
        dis[start] = 0;

        while(!pq.isEmpty()) {
            // 가장 작은 수를 꺼낸다.
            Node node = pq.poll();
            int now = node.now;
            int nowCost = node.cost;

            // 정점까지 오는 비용이 다른 루트로 방문하는 비용보다 비싸면 넘어간다. (최적화)
            if(nowCost > dis[now]) continue;

            for (Node next : list.get(now)) {
                // 다음 정점 현재 최소 비용이 현재 정점에서 다음 정점으로 가는 비용보다 크면 이를 업데이트한다.
                if(dis[next.now] > next.cost + nowCost) {
                    dis[next.now] = next.cost + nowCost;
                    pq.add(new Node(next.now, next.cost + nowCost));
                }
            }
        }

        System.out.println(dis[end]);

    }
}

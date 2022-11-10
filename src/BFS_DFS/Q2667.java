package BFS_DFS;

import java.util.*;

public class Q2667 {

    static int[][] graph;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        graph = new int[n][n];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if(graph[i][j] == 1) {
                    queue.add(new Point(i, j));
                    graph[i][j] = 0;
                    int count = 1;
                    while(!queue.isEmpty()) {
                        int len = queue.size();
                        for(int k = 0; k < len; k++) {
                            Point p = queue.poll();
                            for(int l = 0; l < dx.length; l++) {
                                int nx = p.x + dx[l];
                                int ny = p.y + dy[l];
                                if(nx >= 0 && nx < n && ny >= 0 && ny < n && graph[nx][ny] == 1) {
                                    graph[nx][ny] = 0;
                                    count++;
                                    queue.add(new Point(nx, ny));
                                }
                            }
                        }
                    }
                    answer.add(count);
                }
            }
        }

        System.out.println(answer.size());
        Collections.sort(answer);
        for (Integer integer : answer) {
            System.out.println(integer);
        }

    }
}

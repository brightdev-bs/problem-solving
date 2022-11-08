package BFS_DFS;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 최단 경로를 계산하는 문제에서 DFS를 사용하게 되면, 최단경로의 길이를 변수에 저장해서 답을 찾을 수는 없지만, 그 전에 순회하는 더 긴 길이의 경로가 너무 많을 수 있다.
public class Q2178 {

    static int[][] graph;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static boolean[][] ch;
    static int n,m;

    public static class Point {
        int r, c;

        public Point(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new int[n][m];
        ch = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            String s = sc.next();
            for(int j = 0; j < s.length(); j++) {
                graph[i][j] = s.charAt(j) - '0';
            }
        }

        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        ch[0][0] = true;
        int answer = 0;
        while(!queue.isEmpty()) {
            int len = queue.size();
            answer++;
            for(int i = 0; i < len; i++) {
                Point poll = queue.poll();

                if(poll.r == n - 1 && poll.c == m - 1) {
                    System.out.println(answer);
                    return;
                }

                for(int j = 0; j < dr.length; j++) {
                    int nr = poll.r + dr[j];
                    int nc = poll.c + dc[j];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && !ch[nr][nc] && graph[nr][nc] == 1) {
                        ch[nr][nc] = true;
                        queue.add(new Point(nr, nc));
                    }
                }
            }
        }
        System.out.println(answer);
    }
}

package BFS_DFS;

import java.util.Arrays;
import java.util.Scanner;

public class Q1303 {

    public static char[][] graph;

    public static int answer = 0;

    static int n, m;

    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        graph = new char[m][n];
        for(int i = 0; i < m; i++) {
            String s = sc.next();
            for(int j = 0; j < n; j++) {
                graph[i][j] = s.charAt(j);
            }
        }

        long whiteCount = 0;
        long blueCount = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                answer = 0;
                char color = graph[i][j];
                if(color != 'M') {
                    DFS(i, j, color);

                    if (color == 'W')
                        whiteCount += answer * answer;
                    else
                        blueCount += answer * answer;
                }

            }
        }
        System.out.println(whiteCount);
        System.out.println(blueCount);

    }

    public static void DFS(int x, int y, char c) {

        graph[x][y] = 'M';
        answer += 1;
        for(int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx >= 0 && nx < m &&  ny >= 0 && ny < n && graph[nx][ny] == c) {
                DFS(nx,ny,c);
            }
        }
    }
}

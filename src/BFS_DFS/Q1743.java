package BFS_DFS;

import java.util.Scanner;

public class Q1743 {

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] arr;
    static int n,m,k;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        k = sc.nextInt();

        arr = new int[n+1][m+1];
        for(int i = 0; i < k; i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            arr[r][c] = 1;
        }

        int answer = 0;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= m; j++) {
                if(arr[i][j] == 1) {
                    arr[i][j] = 0;
                    count++;
                    DFS(i, j);
                    answer = Math.max(answer, count);
                    count = 0;
                }
            }
        }

        System.out.println(answer);
    }

    public static void DFS(int r, int c) {
        for(int i = 0; i < dr.length; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(nr >= 1 && nr <= n && nc >= 1 && nc <= m && arr[nr][nc] == 1) {
                count++;
                arr[nr][nc] = 0;
                DFS(nr, nc);
            }
        }
    }
}

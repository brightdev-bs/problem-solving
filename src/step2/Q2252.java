package step2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q2252 {

    static int[] ch;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        ch = new int[n + 1];

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i = 0; i <= n; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.get(a).add(b);
            ch[b]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 1; i <= n; i++) {
            if(ch[i] == 0) queue.add(i);
        }

        while(!queue.isEmpty()) {
            System.out.print(queue.peek() + " ");
            Integer cur = queue.poll();
            for (Integer next : list.get(cur)) {
                ch[next]--;
                if (ch[next] == 0) {
                    queue.add(next);
                }
            }
        }
    }
}

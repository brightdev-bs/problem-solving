package basic;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1038 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Queue<Long> queue = new LinkedList<>();

        if(n < 10) {
            System.out.println(n);
        }

        else if(n > 1022) {
            System.out.println(-1);
        }

        else {
            int size = 0;
            for(int i = 1; i < 10; i++) {
                queue.add((long) i);
                size++;
            }
            while(size < n) {
                long current = queue.poll();
                long until = current % 10;
                for(int i = 0; i < until; i++) {
                    queue.add(current * 10 + i);
                    size++;
                    if(size == n) {
                        System.out.println(current * 10 + i);
                        break;
                    }
                }
            }
        }
    }
}

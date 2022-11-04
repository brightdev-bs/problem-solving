package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1700A {

    static boolean[] use = new boolean[101];
    static int ans = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        int size = 0;
        for(int i = 0; i < k; i++) {

            if(use[arr[i]]) {
                continue;
            }

            // 꽂을 공간이 있으면
            if(size < n) {
                use[arr[i]] = true;
                size++;
            }

            // 꽂을 공간이 없으면
            else {

                List<Integer> list = new ArrayList<>();
                for (int j = i; j < k; j++) {
                    if(use[arr[j]] && !list.contains(arr[j])) {
                        list.add(arr[j]);
                    }
                }

                // 꽂혀 있는 전기기기를 나중에 모두 사용하면 가장 나중에 사용되는 애를 일단 뽑는다.
                if(list.size() == n) {
                    Integer last = list.get(list.size() - 1);
                    use[last] = false;
                }

                // 있으면
                else {
                    for(int a = 0; a < k; a++) {
                        if(use[arr[a]] && !list.contains(arr[a])) {
                            use[arr[a]] = false;
                        }
                    }
                }

                use[arr[i]] = true;
                ans++;
            }
        }



        System.out.println(ans);
    }

}

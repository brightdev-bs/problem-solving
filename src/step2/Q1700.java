package step2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q1700 {

    static boolean[] used;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();


        int[] arr = new int[k];
        for(int i = 0; i < k; i++) {
            arr[i] = sc.nextInt();
        }

        used = new boolean[k + 1];

        int put = 0;
        int ans = 0;
        for(int i = 0; i < k; i++) {

            if(used[arr[i]]) continue;

            // 콘센트에 꽂을 공간이 있으면
            if(put < n) {
                used[arr[i]] = true;
                put++;
            }

            // 콘센트가 비어 있지 않으면
            else {
                ArrayList<Integer> list = new ArrayList<>();
                for(int j = i; j < k; j++) {
                    if(used[arr[j]] && !list.contains(arr[j])) {
                        list.add(arr[j]);
                    }
                }

                // 만약에 콘센트를 모두 사용하고 있다면 -> 가장 나중에 사용되는 애를 일단 제거한다.
                if(list.size() == n) {
                    int remove = list.get(list.size() - 1);
                    used[remove] = false;
                }

                //
                else {
                    for(int j = 0; j < k; j++) {
                        if (used[j] && !list.contains(j)) {
                            used[j] = false;
                            break;
                        }
                    }
                }

                used[arr[i]] = true;
                ans++;
            }
        }

        System.out.println(ans);

    }
}

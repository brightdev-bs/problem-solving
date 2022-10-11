package step2;

import java.util.Scanner;
import java.util.Stack;

public class Q2504_A {

    static int answer = 0;
    static boolean flag = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        Stack<Character> stack = new Stack<>();
        int tmp = 1;
        for(int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if(current == '(') {
                stack.push(current);
                tmp *= 2;
                continue;
            }

            if(current == '[') {
                stack.push(current);
                tmp *= 3;
                continue;
            }

            if(current == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }

                if(s.charAt(i-1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
                continue;
            }

            if(current == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }

                if(s.charAt(i-1) == '[') {
                    answer += tmp;
                }

                stack.pop();
                tmp /= 3;
            }
        }

        if(!flag || !stack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(answer);
        }
    }
}

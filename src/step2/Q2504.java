package step2;

import java.util.Scanner;
import java.util.Stack;

public class Q2504 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Stack<Character> stack = new Stack<>();
        int result = 0;
        int value = 1;

        for(int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);

            if(cur == '(') {
                stack.push(cur);
                value *= 2;
                continue;
            }

            if(cur == '[') {
                stack.push(cur);
                value *= 3;
                continue;
            }

            if(cur == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    result = 0;
                    break;
                }

                if(input.charAt(i-1) == '(') {
                    result += value;
                }
                stack.pop();
                value /= 2;
                continue;
            }

            if(cur == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    result = 0;
                    break;
                }

                if(input.charAt(i-1) == '[') {
                    result += value;
                }
                stack.pop();
                value /= 3;
            }
        }

        if(!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);

    }
}

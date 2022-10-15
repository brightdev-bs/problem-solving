package step2;

import java.util.Scanner;
import java.util.Stack;

public class Q2504_B {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Stack<Character> stack = new Stack<>();
        boolean flag = true;
        int tmp = 1;
        int answer = 0;
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);

            if(c == '(') {
                stack.push(c);
                tmp *= 2;
                continue;
            }

            if(c == '[') {
                stack.push(c);
                tmp *= 3;
                continue;
            }

            if(c == ')') {
                if(stack.isEmpty() || stack.peek() != '(') {
                    flag = false;
                    break;
                }
                if(input.charAt(i-1) == '(') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 2;
                continue;
            }

            if(c == ']') {
                if(stack.isEmpty() || stack.peek() != '[') {
                    flag = false;
                    break;
                }
                if(input.charAt(i-1) == '[') {
                    answer += tmp;
                }
                stack.pop();
                tmp /= 3;
            }
        }

        if(!flag || !stack.isEmpty()) System.out.println(0);
        else System.out.println(answer);
    }
}
// 마지막에 스택 안에 값이 존재할 수 있음.
// 길이는 1이상 30이상이다. char형은 1 바이트이므로 만약 30개가 되면 stackoverflow가 발생한다.
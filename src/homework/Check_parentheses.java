package homework;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Check_parentheses {

    public static boolean isBalanced(String str) {
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) {
                    return false;
                }

                char top = stack.pop();

                if (ch == ')' && top != '(') {
                    return false;
                }
                if (ch == '}' && top != '{') {
                    return false;
                }
                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter the bracket string：");
        String input = scanner.nextLine();

        if (isBalanced(input)) {
            System.out.println("The parentheses are balanced and paired.");
        } else {
            System.out.println("Unbalanced or unpaired parentheses");
        }

        scanner.close();
    }
}

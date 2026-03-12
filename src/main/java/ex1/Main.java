package ex1;

import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean isBalanced(String s) {
        Stack<Character> stack = new ArrayStack<Character>(100);
        Set<Character> open_brackets = Set.of('(', '{', '[');
        Set<Character> close_brackets = Set.of(')', '}', ']');

        for (char c : s.toCharArray()) {
            if (open_brackets.contains(c))
                stack.push(c);
            else if (close_brackets.contains(c)) {
                Character composite = switch (c) {
                    case ')' -> '(';
                    case '}' -> '{';
                    case ']' -> '[';
                    default -> null;
                };
                if (stack.isEmpty() || !(composite == stack.top())) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    static void main(String[] args) {
        String s = "(hello) (world){(((}))}";

        System.out.println(isBalanced(s));
    }
}
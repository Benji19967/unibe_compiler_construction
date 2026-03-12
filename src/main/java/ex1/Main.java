package ex1;

public class Main {

    public boolean isBalanced(String s) {
        Stack<char> stack = new ArrayStack<>(100);

        for (char c : s) {
            System.out.println(c);
        }

    }

    public static void main(String[] args) {
        String s = new String("(hello) (world)");

        isBalanced(s);
    }
}
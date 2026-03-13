package ex1.object;

public class Mult extends Expression {
    private final Expression left;
    private final Expression right;

    public Mult(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        return left.eval() * right.eval();
    }
}

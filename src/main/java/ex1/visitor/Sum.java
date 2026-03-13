package ex1.visitor;

public class Sum implements Expression {
    private final Expression left;
    private final Expression right;

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitSum(this);
    }
}

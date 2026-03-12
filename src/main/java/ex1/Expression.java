package ex1;

abstract class Expression {

    public int eval() {
        return 0;
    }
}

class Number extends Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }
}

class Sum extends Expression {
    private final Expression left;
    private final Expression right;

    public Sum(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public int eval() {
        return left.eval() + right.eval();
    }
}

class Mult extends Expression {
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

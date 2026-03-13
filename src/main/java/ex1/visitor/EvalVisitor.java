package ex1.visitor;

public class EvalVisitor implements Visitor {
    @Override
    public int visitNumber(Number num) {
        return num.getValue();
    }

    @Override
    public int visitSum(Sum sum) {
        return sum.getLeft().accept(this) + sum.getRight().accept(this);
    }

    @Override
    public int visitMult(Mult mult) {
        return mult.getLeft().accept(this) * mult.getRight().accept(this);
    }
}

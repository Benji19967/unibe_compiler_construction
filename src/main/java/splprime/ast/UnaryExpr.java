package splprime.ast;

import splprime.scan.Token;

public class UnaryExpr extends Expr {
    public final Token operator;
    public final Expr right;

    public UnaryExpr(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitUnaryExpr(this);
    }
}
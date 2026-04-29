package splprime.ast_handwritten;

import splprime.scan.Token;

public class UnaryExpr extends Expr {
    public final Token operator;
    public final Expr right;

    public UnaryExpr(Token operator, Expr right) {
        this.operator = operator;
        this.right = right;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitUnaryExpr(this);
    }
}
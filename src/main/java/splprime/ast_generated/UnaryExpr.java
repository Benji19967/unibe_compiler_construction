package splprime.ast_generated;

import splprime.generated_scan.Token;

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
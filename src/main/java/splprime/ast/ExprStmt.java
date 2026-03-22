package splprime.ast;

public class ExprStmt extends Stmt {
    public final Expr expression;

    public ExprStmt(Expr expression) {
        this.expression = expression;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitExprStmt(this);
    }
}

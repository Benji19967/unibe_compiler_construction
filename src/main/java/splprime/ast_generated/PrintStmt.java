package splprime.ast_generated;

public class PrintStmt extends Stmt {
    public final Expr expression;

    public PrintStmt(Expr expression) {
        this.expression = expression;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitPrintStmt(this);
    }
}

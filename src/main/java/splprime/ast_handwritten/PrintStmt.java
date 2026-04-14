package splprime.ast_handwritten;

public class PrintStmt extends Stmt {
    public final Expr expression;

    public PrintStmt(Expr expression) {
        this.expression = expression;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitPrintStmt(this);
    }
}

package splprime.ast;

public class IfStmt extends Stmt {
    public final Expr left;
    public final Stmt statement;
    public final Expr right;

    public IfStmt(Expr left, Stmt statement, Expr right) {
        this.left = left;
        this.statement = statement;
        this.right = right;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitIfStmt(this);
    }
}
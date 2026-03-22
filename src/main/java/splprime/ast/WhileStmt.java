package splprime.ast;

public class WhileStmt extends Stmt {
    public final Expr left;
    public final Stmt statement;

    public WhileStmt(Expr left, Stmt statement) {
        this.left = left;
        this.statement = statement;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitWhileStmt(this);
    }
}
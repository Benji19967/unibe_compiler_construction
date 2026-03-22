package splprime.ast;

public class WhileStmt extends Stmt {
    public final Expr condition;
    public final Stmt statement;

    public WhileStmt(Expr condition, Stmt statement) {
        this.condition = condition;
        this.statement = statement;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitWhileStmt(this);
    }
}
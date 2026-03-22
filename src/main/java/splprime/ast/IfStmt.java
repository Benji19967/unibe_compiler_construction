package splprime.ast;

public class IfStmt extends Stmt {
    public final Expr condition;
    public final Stmt then_statement;
    public final Stmt else_statement;

    public IfStmt(Expr condition, Stmt then_statement, Stmt else_statement) {
        this.condition = condition;
        this.then_statement = then_statement;
        this.else_statement = else_statement;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitIfStmt(this);
    }
}
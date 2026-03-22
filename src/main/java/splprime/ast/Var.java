package splprime.ast;

import splprime.scan.Token;

public class Var extends Stmt {
    final Token name;
    final Expr initializer;

    public Var(Token name, Expr initializer) {
        this.name = name;
        this.initializer = initializer;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitVar(this);
    }
}

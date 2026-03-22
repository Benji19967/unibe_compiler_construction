package splprime.ast;

import splprime.scan.Token;

public class Variable extends Expr {
    public final Token name;

    public Variable(Token name) {
        this.name = name;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitVariable(this);
    }
}

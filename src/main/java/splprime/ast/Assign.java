package splprime.ast;

import splprime.scan.Token;

public class Assign extends Expr {
    public final Token name;
    public final Expr value;

    public Assign(Token name, Expr value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitAssign(this);
    }
}

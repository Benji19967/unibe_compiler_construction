package splprime.ast;

import splprime.scan.Token;

public class Grouping extends Expr {
    public final Expr inner;

    public Grouping(Expr inner) {
        this.inner = inner;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitGrouping(this);
    }
}

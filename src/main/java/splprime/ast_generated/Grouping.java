package splprime.ast_generated;

public class Grouping extends Expr {
    public final Expr inner;

    public Grouping(Expr inner) {
        this.inner = inner;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitGrouping(this);
    }
}

package splprime.ast;

import splprime.scan.Token;

public class Literal extends Expr {
    public final Object value;

    public Literal(Object value) {
        this.value = value;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitLiteral(this);
    }
}

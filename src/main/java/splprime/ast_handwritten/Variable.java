package splprime.ast_handwritten;

import splprime.scan.Token;

public class Variable extends Expr {
    public final Token name;

    public Variable(Token name) {
        this.name = name;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitVariable(this);
    }
}

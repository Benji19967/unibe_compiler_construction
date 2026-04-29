package splprime.ast_generated;

import splprime.generated_scan.Token;

public class Assign extends Expr {
    public final Token name;
    public final Expr value;

    public Assign(Token name, Expr value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitAssign(this);
    }
}

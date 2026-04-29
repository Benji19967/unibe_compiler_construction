package splprime.ast_generated;
import splprime.generated_scan.Token;

public class Literal extends Expr {
    public final Object value;

    public Literal(Object value) {
        this.value = value;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitLiteral(this);
    }
}
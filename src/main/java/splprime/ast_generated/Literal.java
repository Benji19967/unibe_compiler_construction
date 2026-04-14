package splprime.ast_generated;
import splprime.generated_scan.Token;

public class Literal extends Expr {
    public final Token value;

    public Literal(Token value) {
        this.value = value;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitLiteral(this);
    }
}
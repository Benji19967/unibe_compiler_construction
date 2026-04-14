package splprime.ast_handwritten;

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

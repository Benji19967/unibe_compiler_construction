package splprime.ast_handwritten;

import java.util.List;

public class Block extends Stmt {
    public final List<Stmt> statements;

    public Block(List<Stmt> statements) {
        this.statements = statements;
    }

    @Override
    public Object accept(Visitor v) {
        return v.visitBlock(this);
    }
}

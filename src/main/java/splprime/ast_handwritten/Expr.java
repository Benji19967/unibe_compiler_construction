package splprime.ast_handwritten;

public abstract class Expr implements ASTNode {
    public abstract int accept(Visitor v);
}

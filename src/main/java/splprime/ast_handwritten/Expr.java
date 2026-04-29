package splprime.ast_handwritten;

public abstract class Expr implements ASTNode {
    public abstract Object accept(Visitor v);
}

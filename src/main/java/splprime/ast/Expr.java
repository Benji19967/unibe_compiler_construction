package splprime.ast;

public abstract class Expr implements ASTNode {
    public abstract int accept(Visitor v);
}

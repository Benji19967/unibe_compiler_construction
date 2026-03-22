package splprime.ast;

public abstract class Stmt implements ASTNode {
    public abstract int accept(Visitor v);
}

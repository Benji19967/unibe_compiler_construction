package splprime.ast_handwritten;

public abstract class Stmt implements ASTNode {
    public abstract int accept(Visitor v);
}

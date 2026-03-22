package splprime.ast;

public interface Visitor {

    int visitBinaryExpr(BinaryExpr expr);

    int visitUnaryExpr(UnaryExpr expr);

    int visitAssign(Assign expr);

    int visitGrouping(Grouping expr);

    int visitLiteral(Literal expr);

    int visitVariable(Variable expr);

    int visitIfStmt(IfStmt stmt);

    int visitExprStmt(ExprStmt stmt);

    int visitPrintStmt(PrintStmt stmt);

    int visitWhileStmt(WhileStmt stmt);

    int visitBlock(Block stmt);

    int visitVar(Var stmt);
}

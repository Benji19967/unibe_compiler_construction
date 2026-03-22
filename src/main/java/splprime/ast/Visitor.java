package splprime.ast;

public interface Visitor {

    int visitBinaryExpr(BinaryExpr expr);

    int visitIfStmt(IfStmt stmt);

    int visitExprStmt(ExprStmt stmt);

    int visitPrintStmt(PrintStmt stmt);

    int visitWhileStmt(WhileStmt stmt);
}
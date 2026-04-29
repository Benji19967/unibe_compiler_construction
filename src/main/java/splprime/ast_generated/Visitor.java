package splprime.ast_generated;

public interface Visitor {

    Object visitBinaryExpr(BinaryExpr expr);

    Object visitUnaryExpr(UnaryExpr expr);

    Object visitAssign(Assign expr);

    Object visitGrouping(Grouping expr);

    Object visitLiteral(Literal expr);

    Object visitVariable(Variable expr);

    Object visitIfStmt(IfStmt stmt);

    Object visitExprStmt(ExprStmt stmt);

    Object visitPrintStmt(PrintStmt stmt);

    Object visitWhileStmt(WhileStmt stmt);

    Object visitBlock(Block stmt);

    Object visitVar(Var stmt);
}

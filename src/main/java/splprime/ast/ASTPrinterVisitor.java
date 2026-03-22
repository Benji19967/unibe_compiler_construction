package splprime.ast;

public class ASTPrinterVisitor implements Visitor {

    @Override
    public int visitBinaryExpr(BinaryExpr expr) {
        System.out.println();

        return 0;
    }

    @Override
    public int visitUnaryExpr(UnaryExpr expr) {
        System.out.println();

        return 0;
    }

    @Override
    public int visitIfStmt(IfStmt stmt) {
        System.out.println();

        return 0;
    }

    @Override
    public int visitExprStmt(ExprStmt stmt) {
        System.out.println();

        return 0;
    }

    @Override
    public int visitPrintStmt(PrintStmt stmt) {
        System.out.println();

        return 0;
    }

    @Override
    public int visitWhileStmt(WhileStmt stmt) {
        System.out.println();

        return 0;
    }
}

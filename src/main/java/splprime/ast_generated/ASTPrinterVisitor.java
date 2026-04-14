package splprime.ast_generated;

public class ASTPrinterVisitor implements Visitor {

    @Override
    public int visitBinaryExpr(BinaryExpr expr) {
        expr.left.accept(this);
        System.out.print(" " + expr.operator.image + " ");
        expr.right.accept(this);
        return 0;
    }

    @Override
    public int visitUnaryExpr(UnaryExpr expr) {
        System.out.print(expr.operator.image);
        expr.right.accept(this);
        return 0;
    }

    @Override
    public int visitAssign(Assign expr) {
        System.out.print(expr.name.image + " = ");
        expr.value.accept(this);
        // Note: We don't print a semicolon here because Assign is an Expr,
        // and the ExprStmt or VarDecl will handle the semicolon.
        return 0;
    }
    @Override
    public int visitGrouping(Grouping expr) {
        System.out.print("(");
        expr.inner.accept(this);
        System.out.print(")");
        return 0;
    }

    @Override
    public int visitLiteral(Literal expr) {
        System.out.print(expr.value.image);
        return 0;
    }

    @Override
    public int visitVariable(Variable expr) {
        System.out.print(expr.name.image);
        return 0;
    }

    @Override
    public int visitIfStmt(IfStmt stmt) {
        System.out.print("if (");
        stmt.condition.accept(this);
        System.out.print(") ");
        stmt.then_statement.accept(this);
        if (stmt.else_statement != null) {
            System.out.print(" else ");
            stmt.else_statement.accept(this);
        }
        return 0;
    }

    @Override
    public int visitExprStmt(ExprStmt stmt) {
        stmt.expression.accept(this);
        System.out.println(";");
        return 0;
    }

    @Override
    public int visitPrintStmt(PrintStmt stmt) {
        System.out.print("print ");
        stmt.expression.accept(this);
        System.out.println(";");
        return 0;
    }

    @Override
    public int visitWhileStmt(WhileStmt stmt) {
        System.out.print("while (");
        stmt.condition.accept(this);
        System.out.print(") ");
        stmt.statement.accept(this); // This might be a Block or a single Stmt
        return 0;
    }

    @Override
    public int visitBlock(Block stmt) {
        System.out.println("{");
        for (Stmt s : stmt.statements) {
            System.out.print("  "); // Simple indentation
            s.accept(this);
        }
        System.out.println("}");
        return 0;
    }

    @Override
    public int visitVar(Var stmt) {
        System.out.print("var " + stmt.name.image);
        if (stmt.initializer != null) {
            System.out.print(" = ");
            stmt.initializer.accept(this);
        }
        System.out.println(";");
        return 0;
    }
}

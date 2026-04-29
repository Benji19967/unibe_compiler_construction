package splprime.ast_generated;

public class ASTPrinterVisitor implements Visitor {

    @Override
    public Object  visitBinaryExpr(BinaryExpr expr) {
        expr.left.accept(this);
        System.out.print(" " + expr.operator.image + " ");
        expr.right.accept(this);
        return 0;
    }

    @Override
    public Object  visitUnaryExpr(UnaryExpr expr) {
        System.out.print(expr.operator.image);
        expr.right.accept(this);
        return 0;
    }

    @Override
    public Object  visitAssign(Assign expr) {
        System.out.print(expr.name.image + " = ");
        expr.value.accept(this);
        // Note: We don't print a semicolon here because Assign is an Expr,
        // and the ExprStmt or VarDecl will handle the semicolon.
        return 0;
    }
    @Override
    public Object  visitGrouping(Grouping expr) {
        System.out.print("(");
        expr.inner.accept(this);
        System.out.print(")");
        return 0;
    }

    @Override
    public Object  visitLiteral(Literal expr) {
        System.out.print(expr.value);
        return 0;
    }

    @Override
    public Object  visitVariable(Variable expr) {
        System.out.print(expr.name.image);
        return 0;
    }

    @Override
    public Object  visitIfStmt(IfStmt stmt) {
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
    public Object  visitExprStmt(ExprStmt stmt) {
        stmt.expression.accept(this);
        System.out.println(";");
        return 0;
    }

    @Override
    public Object  visitPrintStmt(PrintStmt stmt) {
        System.out.print("print ");
        stmt.expression.accept(this);
        System.out.println(";");
        return 0;
    }

    @Override
    public Object  visitWhileStmt(WhileStmt stmt) {
        System.out.print("while (");
        stmt.condition.accept(this);
        System.out.print(") ");
        stmt.statement.accept(this); // This might be a Block or a single Stmt
        return 0;
    }

    @Override
    public Object  visitBlock(Block stmt) {
        System.out.println("{");
        for (Stmt s : stmt.statements) {
            System.out.print("  "); // Simple indentation
            s.accept(this);
        }
        System.out.println("}");
        return 0;
    }

    @Override
    public Object  visitVar(Var stmt) {
        System.out.print("var " + stmt.name.image);
        if (stmt.initializer != null) {
            System.out.print(" = ");
            stmt.initializer.accept(this);
        }
        System.out.println(";");
        return 0;
    }
}

package splprime.ast_generated;

import splprime.generated_scan.SPLPrimeConstants;
import splprime.generated_scan.Token;

import java.util.List;

public class InterpreterVisitor implements Visitor {

    private Environment environment = new Environment(null);

    public void interpret(List<Stmt> statements) {
        for (Stmt statement : statements) {
            execute(statement);
        }
    }

    private void execute(Stmt stmt) {
        stmt.accept(this);
    }

    private Object evaluate(Expr expr) {
        return expr.accept(this);
    }

    @Override
    public Object visitBinaryExpr(BinaryExpr expr) {
        Object left = evaluate(expr.left);
        Object right = evaluate(expr.right);
        switch (expr.operator.kind) {
            // --- EQUALITY ---
            case SPLPrimeConstants.NOT_EQUAL:
                return !isEqual(left, right);
            case SPLPrimeConstants.EQUAL_EQUAL:
                return isEqual(left, right);

            // --- COMPARISON ---
            case SPLPrimeConstants.GREATER:
                checkNumberOperands(expr.operator, left, right);
                return ((Number)left).doubleValue() > ((Number)right).doubleValue();
            case SPLPrimeConstants.LESS:
                checkNumberOperands(expr.operator, left, right);
                return ((Number)left).doubleValue() < ((Number)right).doubleValue();
            case SPLPrimeConstants.GREATER_EQUAL:
                checkNumberOperands(expr.operator, left, right);
                return ((Number)left).doubleValue() >= ((Number)right).doubleValue();
            case SPLPrimeConstants.LESS_EQUAL:
                checkNumberOperands(expr.operator, left, right);
                return ((Number)left).doubleValue() <= ((Number)right).doubleValue();

            // --- ARITHMETIC ---
            case SPLPrimeConstants.PLUS:
                if (left instanceof Integer && right instanceof Integer) {
                    return (int)left + (int)right;
                }
                if (left instanceof Number && right instanceof Number) {
                    return ((Number)left).doubleValue() + ((Number)right).doubleValue();
                }
                // Optional: Handle string concatenation if your language supports it
                if (left instanceof String || right instanceof String) {
                    return String.valueOf(left) + String.valueOf(right);
                }
                throw new RuntimeException("Operands must be numbers or strings. " +
                        "Left: " + left.getClass().getName() + " " +
                        "Right: " + right.getClass().getName()
                );
            case SPLPrimeConstants.MINUS:
                checkNumberOperands(expr.operator, left, right);
                if (left instanceof Integer && right instanceof Integer) {
                    return (int)left - (int)right;
                }
                return ((Number)left).doubleValue() - ((Number)right).doubleValue();
            case SPLPrimeConstants.STAR:
                checkNumberOperands(expr.operator, left, right);
                if (left instanceof Integer && right instanceof Integer) {
                    return (int)left * (int)right;
                }
                return ((Number)left).doubleValue() * ((Number)right).doubleValue();
            case SPLPrimeConstants.DIVIDE:
                checkNumberOperands(expr.operator, left, right);
                if (left instanceof Integer && right instanceof Integer) {
                    return (int)left / (int)right;
                }
                return ((Number)left).doubleValue() / ((Number)right).doubleValue();

            // --- LOGIC ---
            case SPLPrimeConstants.OR:
                if (isTrue(left)) return left;
                return evaluate(expr.right);
            case SPLPrimeConstants.AND:
                if (!isTrue(left)) return left;
                return evaluate(expr.right);
        }
        return null;
    }

    @Override
    public Object visitUnaryExpr(UnaryExpr expr) {
        Object e = evaluate(expr.right);
        switch (expr.operator.kind) {
            case SPLPrimeConstants.NOT:
                if (e instanceof Boolean) {
                    return !((Boolean) e).booleanValue();
                }
                throw new RuntimeException("Expected boolean value");
            case SPLPrimeConstants.MINUS:
                if (e instanceof Integer) {
                    return -((Integer) e).intValue();
                }
                if (e instanceof Number) {
                    return -((Number) e).doubleValue();
                }
                throw new RuntimeException("Expected number value");
        }
        return null;
    }

    @Override
    public Object visitAssign(Assign expr) {
        Object value = evaluate(expr.value);
        environment.assign(expr.name.image, value);

        return value;
    }

    @Override
    public Object visitGrouping(Grouping expr) {
        return evaluate(expr.inner);
    }

    @Override
    public Object visitLiteral(Literal expr) {
        return expr.value;
    }

    @Override
    public Object visitVariable(Variable expr) {
        return environment.get(expr.name.image);
    }

    @Override
    public Object visitIfStmt(IfStmt stmt) {
        if (isTrue(evaluate(stmt.condition))) {
            execute(stmt.then_statement);
        } else if (stmt.else_statement != null) {
            execute(stmt.else_statement); }
        return null;
    }

    @Override
    public Object visitExprStmt(ExprStmt stmt) {
        evaluate(stmt.expression);
        return null;
    }

    @Override
    public Object visitPrintStmt(PrintStmt stmt) {
        Object value = evaluate(stmt.expression);
        System.out.println(value);
        return null;
    }

    @Override
    public Object visitWhileStmt(WhileStmt stmt) {
        while (isTrue(evaluate(stmt.condition))) {
            execute(stmt.statement);
        }
        return null;
    }

    @Override
    public Object visitBlock(Block stmt) {
        executeBlock(stmt.statements, new Environment(environment));
        return null;
    }

    void executeBlock(List<Stmt> statements, Environment environment) {
        Environment previous = this.environment;
        this.environment = environment;

        for (Stmt statement : statements) {
            execute(statement);
        }

        this.environment = previous;
    }

    @Override
    public Object visitVar(Var stmt) {
        Object value = null;
        if (stmt.initializer != null) {
            value = evaluate(stmt.initializer);
        }
        environment.define(stmt.name.image, value);
        return 0;
    }

    private boolean isTrue(Object o) {
        if (o instanceof String) {
            if (o == "") {
                return false;
            } else
                return true;
        }
        if (o instanceof Boolean) {
            return ((Boolean) o).booleanValue();
        }
        if (o instanceof Number) {
            if (((Number) o).doubleValue() == 0.0) {
                return false;
            } else
                return true;
        }
        throw new RuntimeException("Unexpected boolean type");
    }

    private boolean isEqual(Object a, Object b) {
        if (a == null && b == null) return true;
        if (a == null) return false;
        return a.equals(b);
    }

    private void checkNumberOperands(Token operator, Object left, Object right) {
        if (left instanceof Number && right instanceof Number) {
            return;
        }
        throw new RuntimeException(
                "Line " + operator.beginLine + ": Operands for '" + operator.image + "' must be numbers."
        );
    }

    private void checkNumberOperand(Token operator, Object operand) {
        if (operand instanceof Number) return;
        throw new RuntimeException(
                "Line " + operator.beginLine + ": Operand for '" + operator.image + "' must be a number."
        );
    }
}

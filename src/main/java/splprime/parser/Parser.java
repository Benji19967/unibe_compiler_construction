package splprime.parser;

import splprime.ast.*;
import splprime.scan.Token;
import splprime.scan.TokenType;

import java.util.List;
import java.util.ArrayList;

public class Parser {
    private final List<Token> tokens;
    private int current = 0;

    public Parser(List<Token> tokens) {
        this.tokens = tokens;
    }

    public List<Stmt> parse() throws Exception {
        return program();
    }

    // --- Grammar rules ---

    private List<Stmt> program() throws Exception {
        List<Stmt> statements = new ArrayList<>();

        while (!isAtEnd()) {
            statements.add(declaration());
        }

        return statements;
    }

    private Stmt declaration() throws Exception {
        if (match(TokenType.VAR)) {
            Var var;
            if (match(TokenType.IDENTIFIER)) {
                Token name = previous();
                if (match(TokenType.EQUAL)) {
                    var = new Var(name, expression());
                } else {
                    var = new Var(name, null);
                }
            } else {
                throw new Exception("Expected Identifier");
            }
            match(TokenType.SEMICOLON);
            return var;
        } else {
            return statement();
        }
    }

    private Stmt statement() throws Exception {
        // TODO: could extract each if block into its own function
        if (match(TokenType.IF)) {
            match(TokenType.LEFT_PAREN);
            Expr condition = expression();
            match(TokenType.RIGHT_PAREN);
            Stmt then_stmt = statement();
            if (match(TokenType.ELSE)) {
                Stmt else_stmt = statement();
                return new IfStmt(condition, then_stmt, else_stmt);
            }
            return new IfStmt(condition, then_stmt, null);
        } else if (match(TokenType.PRINT)) {
            Expr expr = expression();
            match(TokenType.SEMICOLON);
            return new PrintStmt(expr);
        } else if (match(TokenType.WHILE)) {
            match(TokenType.LEFT_PAREN);
            Expr condition = expression();
            match(TokenType.RIGHT_PAREN);
            Stmt stmt = statement();
            return new WhileStmt(condition, stmt);
        } else if (match(TokenType.LEFT_BRACE)) {
            List<Stmt> statements = new ArrayList<>();
            while (!match(TokenType.RIGHT_BRACE)) {
                    statements.add(declaration());
            }
            return new Block(statements);
        } else {
            Expr expr = expression();
            match(TokenType.SEMICOLON);
            return new ExprStmt(expr);

        }
    }

    private Expr expression() throws Exception {
        return assignment();
    }

    private Expr assignment() throws Exception {
        if (match(TokenType.IDENTIFIER)) {
            Token name = previous();
            if (match(TokenType.EQUAL)) {
                Expr value = assignment();
                return new Assign(name, value);
            } else {
                current--;
                return logic_or();
            }
        }
        return logic_or();
    }

    private Expr logic_or() throws Exception {
        Expr expr = logic_and();
        while (match(TokenType.OR)) {
            Token or = previous();
            Expr and = logic_and();
            expr = new BinaryExpr(expr, or, and);
        }
        return expr;
    }

    private Expr logic_and() throws Exception {
        Expr expr = equality();
        while (match(TokenType.AND)) {
            Token and = previous();
            Expr eq = equality();
            expr = new BinaryExpr(expr, and, eq);
        }
        return expr;
    }

    private Expr equality() throws Exception {
        Expr expr = comparison();
        while (match(TokenType.NOT_EQUAL, TokenType.EQUAL_EQUAL)) {
            Token operator = previous();
            Expr comp = comparison();
            expr = new BinaryExpr(expr, operator, comp);
        }
        return expr;
    }

    private Expr comparison() throws Exception {
        Expr expr = term();
        while (match(TokenType.GREATER, TokenType.GREATER_EQUAL, TokenType.LESS, TokenType.LESS_EQUAL)) {
            Token operator = previous();
            Expr comp = term();
            expr = new BinaryExpr(expr, operator, comp);
        }
        return expr;
    }


    private Expr term() throws Exception {
        Expr expr = factor();

        while (match(TokenType.PLUS, TokenType.MINUS)) {
            Token operator = tokens.get(current - 1);
            Expr right = factor();
            expr = new BinaryExpr(expr, operator, right);
        }

        return expr;
    }

    private Expr factor() throws Exception {
        Expr expr = unary();

        while (match(TokenType.DIVIDE, TokenType.STAR)) {
            Token operator = tokens.get(current - 1);
            Expr right = unary();
            expr = new BinaryExpr(expr, operator, right);
        }

        return expr;
    }

    private Expr unary() throws Exception {
        if (match(TokenType.NOT, TokenType.MINUS)) {
            Token operator = previous();
            Expr right = unary();
            return new UnaryExpr(operator, right);
        }

        return primary();
    }

    private Expr primary() throws Exception {
        if (match(TokenType.TRUE, TokenType.FALSE, TokenType.NUMBER, TokenType.STRING)) {
            Token token = previous();
            return new Literal(token);
        } else if (match(TokenType.LEFT_PAREN)) {
            Expr expr = expression();
            if(match(TokenType.RIGHT_PAREN)) {
                return new Grouping(expr); // TODO: could I just return expr?
            }
        } else if (match(TokenType.IDENTIFIER)) {
            Token token = previous();
            System.out.println(token);
            return new Variable(token);
        }

        throw new Exception("Could not get primary");
    }

    // --- Helpers ---

    // '...' syntax: 'varargs' --> pass one or more TokenType
    // Helper: is the current token of one of these types?
    private boolean match(TokenType... types) {
        for (TokenType type : types) {
            if (tokens.get(current).type == type) {
                current++;
                return true;
            }
        }
        return false;
    }

    private boolean isAtEnd() {
        return tokens.get(current).type == TokenType.EOF;
    }

    private Token previous() {
        return tokens.get(current - 1);
    }
}

package ex1.visitor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressionTest {
    @Test
    void evalExpression() {
        Visitor evalVisitor = new EvalVisitor();
        Expression expr = new Sum(new Number(5), new Mult(new Number(2), new Number(10)));

        assertEquals(25, expr.accept(evalVisitor));
    }
}

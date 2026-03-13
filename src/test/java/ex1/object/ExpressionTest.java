package ex1.object;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExpressionTest {
    @Test
    void evalNumber() {
        Number num = new Number(5);

        assertEquals(5, num.eval());
    }
    @Test
    void evalSum() {
        Sum sum = new Sum(new Number(4), new Number(5));

        assertEquals(9, sum.eval());
    }
    @Test
    void evalMult() {
        Mult mult = new Mult(new Number(4), new Number(5));

        assertEquals(20, mult.eval());
    }
    @Test
    void evalExpression() {
        Expression expr = new Sum(new Number(5), new Mult(new Number(2), new Number(10)));

        assertEquals(25, expr.eval());
    }
}

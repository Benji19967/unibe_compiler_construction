package ex1;

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
}

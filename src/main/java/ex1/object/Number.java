package ex1.object;


public class Number extends Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    @Override
    public int eval() {
        return value;
    }

}

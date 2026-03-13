package ex1.visitor;

public class Number implements Expression {
    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int accept(Visitor v) {
        return v.visitNumber(this);
    }

}

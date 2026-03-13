package ex1.visitor;

public interface Expression {
    public int accept(Visitor v);
}

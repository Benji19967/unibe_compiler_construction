package ex1.visitor;


public interface Visitor {

    int visitNumber(Number num);

    int visitSum(Sum sum);

    int visitMult(Mult mult);

}
package ex1;

public interface Stack<E> {
    public boolean isEmpty();
    public int size();
    public void push (E item ) ;
    public E top ( ) ;
    public void pop ( ) ;
}
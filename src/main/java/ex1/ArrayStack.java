package ex1;

public class ArrayStack<E> implements Stack<E> {
    private Object[] data;
    private int top = 0;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return top == 0;
    }
    @Override
    public int size() {
        return top;
    }

    @Override
    public void push (E item ) {
        data[top++] = item;
    }

    @Override
    public E top ( ) {
        return (E) data[top - 1];
    }

    public void pop ( ) {
        top--;
    }
}
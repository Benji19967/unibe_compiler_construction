public class ArrayStack<E> implements IStack<E> {
    private Object[] data;
    private int top = 0;

    public ArrayStack(int capacity) {
        data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return data.length == 0;
    }
    @Override
    public int size() {
        return data.length;
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
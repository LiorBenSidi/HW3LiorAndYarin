package Matar;

import java.util.Iterator;

public class ArrayStack<E extends Cloneable> implements Stack<E> {
    private final int MAXSIZE;
    private int topIndex;

    public ArrayStack(int maxsize) {
        if (maxsize > 0) {
            this.MAXSIZE = maxsize;
            this.topIndex = -1;
        } else throw new NegativeCapacityException();
    }

    @Override
    public void push(E element) {
        if (topIndex == MAXSIZE -1) {
            throw new StackOverflowException();
        }
        topIndex++;
    }

    @Override
    public E pop() {
        if (topIndex == -1) {
            throw new EmptyCapacityException();
        } else {
            topIndex--;
            return element;
        }
    }

    @Override
    public E peek() {
        if (topIndex > -1) {
        } else throw new EmptyStackException();

    }

    @Override
    public int size() {
        return topIndex + 1;
    }

    @Override
    public boolean isEmpty() {
        return topIndex == -1;
    }

    @Override
    public ArrayStack<E> clone() {
        try {
            ArrayStack<E> clone = (ArrayStack<E>) super.clone();
            return clone;
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayStackIterator();
    }

    private class ArrayStackIterator implements Iterator<E> {
        private int currentIndex;

        public ArrayStackIterator() {
            currentIndex = topIndex;
        }

        @Override
        public boolean hasNext() {
            return currentIndex >= 0;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                return null;
            }
            currentIndex--;
        }
    }
}

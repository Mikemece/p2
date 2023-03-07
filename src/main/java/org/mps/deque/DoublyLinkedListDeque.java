package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        // TODO
    }

    @Override
    public void prepend(T value) {
        // TODO
    }

    @Override
    public void append(T value) {
        // TODO
    }

    @Override
    public void deleteFirst() {

        if (first == null) {
            throw new RuntimeException("Can't delete first element of empty list");
        }
        DequeNode<T> next = first.getNext();
        first = next;
        if (first != null) first.setPrevious(null);
    }

    @Override
    public void deleteLast() {
        if (last == null) {
            throw new RuntimeException("Can't delete last element of empty list");
        }
        DequeNode<T> prev = last.getPrevious();
        last = prev;
        if (last != null) last.setNext(null);
    }

    @Override
    public T first() {
        // TODO
        return null;
    }

    @Override
    public T last() {
        // TODO
        return null;
    }

    @Override
    public int size() {
        // TODO
        return 0;
    }
}

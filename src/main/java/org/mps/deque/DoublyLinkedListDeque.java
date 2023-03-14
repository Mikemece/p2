package org.mps.deque;

public class DoublyLinkedListDeque<T> implements DoubleEndedQueue<T> {

    private DequeNode<T> first;
    private DequeNode<T> last;
    private int size;

    public DoublyLinkedListDeque() {
        size = 0;
        first = null;
        last = null;
    }

    @Override
    public void prepend(T value) {
        size++;
        DequeNode<T> node = new DequeNode<T>(value, null, null);
        if (first == null) { // Lista vacía
            first = node;
            last = node;
            // los punteros del nodo se quedan a null
        } else { // lista no vacía
            first.setPrevious(node);
            node.setNext(first);
            first = node;
        }
    }

    @Override
    public void append(T value) {
        size++;
        DequeNode<T> node = new DequeNode<T>(value, null, null);
        if (first == null) { // Lista vacía
            first = node;
            last = node;
            // los punteros del nodo se quedan a null
        } else { // lista no vacía
            last.setNext(node);
            node.setPrevious(last);
            last = node;
        }
    }

    @Override
    public void deleteFirst() {
        if (first == null) { // lista vacía
            throw new DoubleEndedQueueException("Can't delete first element of empty list");
        }
        size--;
        if (first == last) { // lista con un elemento
            first = null;
            last = null;
        } else { // lista con mas de un elemento
            first = first.getNext();
            first.setPrevious(null);
        }
    }

    @Override
    public void deleteLast() {
        if (last == null) { // lista vacía
            throw new DoubleEndedQueueException("Can't delete last element of empty list");
        }
        size--;
        if (first == last) { // lista con un elemento
            first = null;
            last = null;
        } else { // lista con mas de un elemento
            last = last.getPrevious();
            last.setNext(null);
        }
    }

    @Override
    public T first() {
        if (first == null) return null;
        return first.getItem();
    }

    @Override
    public T last() {
        if (last == null) return null;
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    public T get(int index){
        DequeNode<T> nodo = first;
        while(index>0){
            nodo = nodo.getNext();
            index--;
            if(nodo==null){
                throw new DoubleEndedQueueException("Index out of bounds");
            }
        }

        return nodo.getItem();
    }
}

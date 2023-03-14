package org.mps.deque;

import java.util.Comparator;

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
        DequeNode<T> nodo = new DequeNode<T>(value, null, first);
        if(first!=null){
            first.setPrevious(nodo);
            first = nodo;
        }else{
            first = nodo;
            last = nodo;
        }
    }

    @Override
    public void append(T value) {
        size++;
        DequeNode<T> nodo = new DequeNode<T>(value, last, null);
        if(last!=null){
            last.setNext(nodo);
            last = nodo;
        }else{
            first = nodo;
            last = nodo;
        }

    }

    @Override
    public void deleteFirst() {
        if (first == null) {
            throw new DoubleEndedQueueException("Can't delete first element of empty list");
        }
        DequeNode<T> next = first.getNext();
        first = next;
        if (first != null) first.setPrevious(null);
    }

    @Override
    public void deleteLast() {
        if (last == null) {
            throw new DoubleEndedQueueException("Can't delete last element of empty list");
        }
        DequeNode<T> prev = last.getPrevious();
        last = prev;
        if (last != null) last.setNext(null);
    }

    @Override
    public T first() {
        return first.getItem();
    }

    @Override
    public T last() {
        return last.getItem();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        DequeNode<T> nodo= first;
        while(index>0){
            nodo = nodo.getNext();
            index--;
            if(nodo==null){
                throw new DoubleEndedQueueException("Index out of bounds");
            }
        }
        return  nodo.getItem();
    }

    @Override
    public boolean contains(T value) {

        return false;
    }

    @Override
    public void remove(T value) {
        DequeNode<T> nodo= first;
        while(!nodo.getItem().equals(value)){
            if(nodo.getNext()==null){
                throw new DoubleEndedQueueException("Value to remove not founded");
            }
            nodo=nodo.getNext();
        }
        nodo.getPrevious().setNext(nodo.getNext());
        nodo.getNext().setPrevious(nodo.getPrevious());
        size--;
        //nodo=null;
    }

    @Override
    public void sort(Comparator<? super T> comparator) {

    }
}

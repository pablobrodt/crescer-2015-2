package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class LinkedList<T> extends MyList<T> {

    private Node<T> first, last;

    @Override
    public void addFirst(T value) {
        Node<T> novoNodo = new Node<T>(value, first);
        if (this.first == null) {
            this.last = novoNodo;
        }
        this.first = novoNodo;
    }

    @Override
    public void addLast(T value) {
        Node<T> novoNodo = new Node<T>(value);
        if (this.last == null) {
            this.first = novoNodo;
            this.first.setNext(last);
            this.last = novoNodo;
        } else {
            this.last.setNext(novoNodo);
            this.last = novoNodo;
        }
    }

    @Override
    public T getFirst() {
        return this.first.getValue();
    }

    @Override
    public T getLast() {
        return this.last.getValue();
    }

    @Override
    public List<T> list() {
        ArrayList<T> lista = new ArrayList<>();
        Node<T> nodo = first;
        while (nodo != null) {
            lista.add(nodo.getValue());
            nodo = nodo.getNext();
        }
        return lista;
    }

    @Override
    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    @Override
    public void remove(int index) {
        int i = 0;
        Node<T> nodo = getNode(index - 1);
        Node<T> removido = nodo.getNext();
        Node<T> proximoNodo = removido.getNext();
        nodo.setNext(proximoNodo);
    }

    @Override
    public void add(int index, T value) {
        Node<T> novoNodo = new Node<T>(value);
        Node<T> nodo = getNode(index - 1);
        Node<T> proximoNodo = nodo.getNext();
        novoNodo.setNext(proximoNodo);
        nodo.setNext(novoNodo);
    }

    @Override
    public boolean isEmpty() {
        return this.first == null;
    }

    // Metodos internos
    private Node<T> getNode(int index) {
        int i = 0;
        Node<T> nodo = first;
        while (i < index) {
            nodo = nodo.getNext();
            i++;
        }
        return nodo;
    }

    // Classes internas
    private class Node<T> {

        private T value;

        private Node<T> next;

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value) {
            this.value = value;
        }

        public Node getNext() {
            return this.next;
        }

        public T getValue() {
            return this.value;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

}

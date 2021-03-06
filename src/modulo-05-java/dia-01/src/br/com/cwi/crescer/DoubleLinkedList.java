package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T> extends MyList<T> {

    private Node<T> first, last;

    @Override
    public void addFirst(T value) {
        Node<T> novoNodo = new Node<T>(value, this.first);
        if (this.first == null) {
            this.last = novoNodo;
        } else {
            this.first.setPrevious(novoNodo);
        }
        this.first = novoNodo;
    }

    @Override
    public void addLast(T value) {
        Node<T> novoNodo = new Node<T>(value, null, this.last);
        if (this.last == null) {
            this.first = novoNodo;
            this.first.setNext(this.last);
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
        Node<T> nodo = this.first;
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
        Node<T> removido = getNode(index);
        Node<T> anterior = removido.getPrevious();
        anterior.setNext(removido.getNext());
    }

    @Override
    public void add(int index, T value) {
        Node<T> novoNodo = new Node<T>(value);
        Node<T> nodo = getNode(index);
        Node<T> nodoAnterior = nodo.getPrevious();
        Node<T> nodoPosterior = nodo.getNext();

        nodoAnterior.setNext(novoNodo);
        nodoPosterior.setPrevious(novoNodo);

        novoNodo.setPrevious(nodo.getPrevious());
        novoNodo.setNext(nodo);
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

        private Node<T> next, previous;

        public Node(T value) {
            this.value = value;
        }

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node<T> getNext() {
            return this.next;
        }

        public Node<T> getPrevious() {
            return this.previous;
        }

        public T getValue() {
            return this.value;
        }

        public void setNext(Node<T> next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }
}

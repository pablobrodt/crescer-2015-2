package br.com.cwi.crescer;

import java.util.ArrayList;
import java.util.List;

public class DoubleLinkedList<T> {

    private Node<T> first, last;

    public void addFirst(T value) {
        Node<T> node = new Node<T>(value, first, null);
        if (first == null) {
            last = node;
        }
        first = node;
    }

    public void addLast(T value) {
        Node<T> novoNodo = new Node<T>(value);
        if (this.first == null) {
            this.first = novoNodo;
            this.last = novoNodo;
        }

    }

    public T getFirst() {
        return this.first.getValue();
    }

    public T getLast() {
        return this.last.getValue();
    }

    public List<T> list() {
        ArrayList<T> lista = new ArrayList<>();
        Node<T> nodo = first;
        while (nodo != null) {
            lista.add(nodo.getValue());
            nodo = nodo.getNext();
        }
        return lista;
    }

    public void removeFirst() {
        if (first != null) {
            first = first.getNext();
        }
    }

    public void remove(int index) {
        int i = 0;
        Node<T> nodo = getNode(index - 1);
        Node<T> removido = nodo.getNext();
        Node<T> proximoNodo = removido.getNext();
        nodo.setNext(proximoNodo);
    }

    public void add(int index, T value) {
        Node<T> novoNodo = new Node<T>(value);
        Node<T> nodo = getNode(index - 1);
        Node<T> proximoNodo = nodo.getNext();
        novoNodo.setNext(proximoNodo);
        nodo.setNext(novoNodo);
    }

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

        public Node(T value, Node next) {
            this.value = value;
            this.next = next;
        }

        public Node(T value, Node next, Node previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrevious() {
            return this.previous;
        }

        public T getValue() {
            return this.value;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public void setPrevious(Node previous) {
            this.previous = previous;
        }
    }

}

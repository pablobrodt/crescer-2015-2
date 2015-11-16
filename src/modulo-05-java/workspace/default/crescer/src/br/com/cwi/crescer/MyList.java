package br.com.cwi.crescer;

import java.util.List;

public abstract class MyList {

    // private Node first, last;

    public abstract void addFirst(String value);

    public abstract void addLast(String value);

    public abstract void add(int index, String value);

    public abstract void removeFirst();

    public abstract void remove(int index);

    public abstract String getFirst();

    public abstract String getLast();

    public abstract List<String> list();

    public abstract boolean isEmpty();

    // Metodos internos
    // private abstract Node getNode(int index);
}

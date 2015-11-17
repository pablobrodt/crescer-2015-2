package br.com.cwi.crescer;

import java.util.List;

public abstract class MyList<T> {

    public abstract void addFirst(T value);

    public abstract void addLast(T value);

    public abstract void add(int index, T value);

    public abstract void removeFirst();

    public abstract void remove(int index);

    public abstract T getFirst();

    public abstract T getLast();

    public abstract List<T> list();

    public abstract boolean isEmpty();
}

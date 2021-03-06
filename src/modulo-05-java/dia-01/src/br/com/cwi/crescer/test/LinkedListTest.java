package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cwi.crescer.LinkedList;

public class LinkedListTest {

    @Test
    public void adicionaPrimeiroNaLista() {
        // Arrange
        String valorEsperado = "Ni";
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Ichi");

        // Act
        lista.addFirst("Ni");

        // Assert
        assertEquals(valorEsperado, lista.getFirst());
    }

    @Test
    public void adiicionarPrimeiroNodoCincoVezes() {
        // Arrange
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Shi");
        listaEsperada.add("Go");

        LinkedList<String> lista = new LinkedList<>();

        // Act
        lista.addFirst("Go");
        lista.addFirst("Shi");
        lista.addFirst("San");
        lista.addFirst("Ni");
        lista.addFirst("Ichi");

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void primeiroNodoTambémÉOÚltimo() {
        // Arrange
        String valorEsperado = "Ichi";
        LinkedList<String> lista = new LinkedList<String>();

        // Act
        lista.addFirst("Ichi");

        // Assert
        assertEquals(valorEsperado, lista.getLast());
    }

    @Test
    public void adicionaNodoAoFimDaLista() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Ichi");
        lista.addFirst("Ni");

        String valorEsperado = "San";

        // Act
        lista.addLast("San");

        // Assert
        assertEquals(valorEsperado, lista.getLast());
    }

    @Test
    public void linkedListListaTemNodosComValoresIchiNiSan() {
        //Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("San");
        lista.addFirst("Ni");
        lista.addFirst("Ichi");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        //Act
        List<String> listaObtida = lista.list();

        //Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void removeNodoDeIndiceTrêsDeUmaListaDeCinco() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Go");
        lista.addFirst("Shi");
        lista.addFirst("San");
        lista.addFirst("Ni");
        lista.addFirst("Ichi");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Go");

        // Act
        lista.remove(3);
        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionaNodoNaTerceiraPosiçãoEmListaDeCinco() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Go");
        lista.addFirst("Shi");
        lista.addFirst("San");
        lista.addFirst("Ni");
        lista.addFirst("Ichi");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Novo Nodo");
        listaEsperada.add("Shi");
        listaEsperada.add("Go");

        // Act
        lista.add(3, "Novo Nodo");
        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionarUltimoNodoDuasVezes() {
        // Arrange
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");

        LinkedList<String> lista = new LinkedList<>();

        // Act
        lista.addLast("Ichi");
        lista.addLast("Ni");

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionaUltimoNodoCincoVezes() {
        // Arrange
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Shi");
        listaEsperada.add("Go");

        LinkedList<String> lista = new LinkedList<>();

        // Act
        lista.addLast("Ichi");
        lista.addLast("Ni");
        lista.addLast("San");
        lista.addLast("Shi");
        lista.addLast("Go");

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

}

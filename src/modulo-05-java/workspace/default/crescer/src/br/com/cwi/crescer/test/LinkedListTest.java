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
        String valorEsperado = "Segundo";
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("primeiro");

        // Act
        lista.addFirst("Segundo");

        // Assert
        assertEquals(valorEsperado, lista.getFirst());
    }

    @Test
    public void primeiroNodoTambémÉOÚltimo() {
        // Arrange
        String valorEsperado = "Primeiro";
        LinkedList<String> lista = new LinkedList<String>();

        // Act
        lista.addFirst("Primeiro");

        // Assert
        assertEquals(valorEsperado, lista.getLast());
    }

    @Test
    public void adicionaNodoAoFimDaLista() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Segundo");
        lista.addFirst("Primeiro");

        String valorEsperado = "Terceiro";

        // Act
        lista.addLast("Terceiro");

        // Assert
        assertEquals(valorEsperado, lista.getLast());
    }

    @Test
    public void linkedListListaTemNodosComValoresPrimeiroSegundoETerceiro() {
        //Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Terceiro");
        lista.addFirst("Segundo");
        lista.addFirst("Primeiro");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Primeiro");
        listaEsperada.add("Segundo");
        listaEsperada.add("Terceiro");
        //Act
        List<String> listaObtida = lista.list();

        //Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void removeItemDeIndiceTrêsDeUmaListaDeCincoItens() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Cinco");
        lista.addFirst("Quatro");
        lista.addFirst("Três");
        lista.addFirst("Dois");
        lista.addFirst("Um");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Um");
        listaEsperada.add("Dois");
        listaEsperada.add("Três");
        listaEsperada.add("Cinco");

        // Act
        lista.remove(3);
        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionaNaTerceiraPosiçãoEmListaDeCinco() {
        // Arrange
        LinkedList<String> lista = new LinkedList<String>();
        lista.addFirst("Cinco");
        lista.addFirst("Quatro");
        lista.addFirst("Três");
        lista.addFirst("Dois");
        lista.addFirst("Um");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Um");
        listaEsperada.add("Dois");
        listaEsperada.add("Três");
        listaEsperada.add("Novo Nodo");
        listaEsperada.add("Quatro");
        listaEsperada.add("Cinco");

        // Act
        lista.add(3, "Novo Nodo");
        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionarUltimoDuasVezes() {
        // Arrange
        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Priveiro");
        listaEsperada.add("Segundo");

        LinkedList<String> lista = new LinkedList<>();

        // Act
        lista.addLast("Primeiro");
        lista.addLast("Segundo");

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

}

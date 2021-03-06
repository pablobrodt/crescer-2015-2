package br.com.cwi.crescer.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import br.com.cwi.crescer.DoubleLinkedList;


public class DoubleLinkedListTest {

    @Test
    public void adicionaUmNodoNoInicio() {
        // Arrang
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addFirst("Ni");

        String valorEsperado = "Ichi";

        // Act
        lista.addFirst("Ichi");
        String valorObtido = lista.getFirst();

        // Assert
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void adicionaCincoNodosNoInicio() {
        // Arrang
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Shi");
        listaEsperada.add("Go");

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
    public void adicionaUmNodoNoFim() {
        // Arrang
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Ichi");

        String valorEsperado = "Ni";

        // Act
        lista.addLast("Ni");
        String valorObtido = lista.getLast();

        // Assert
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void adicionaCincoNodosNoFim() {
        // Arrang
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Shi");
        listaEsperada.add("Go");

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

    @Test
    public void primeiroNodoTemValueIchi() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addFirst("Ichi");

        String valorEsperado = "Ichi";

        // Act
        String valorObtido = lista.getFirst();

        // Assert
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void ultimoNodoTemValueGo() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Go");

        String valorEsperado = "Go";

        // Act
        String valorObtido = lista.getFirst();

        // Assert
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void adicionandoUmNodoNoInicioOValueDoPrimeiroEDoÚltimoÉOMesmo() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addFirst("Ichi");

        // Act
        String valorPrimeiro = lista.getFirst();
        String valorUltimo = lista.getLast();

        // Assert
        assertEquals(valorPrimeiro, valorUltimo);
    }

    @Test
    public void adicionandoUmNodoNoFimOValueDoPrimeiroEDoÚltimoÉOMesmo() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Go");

        // Act
        String valorPrimeiro = lista.getFirst();
        String valorUltimo = lista.getLast();

        // Assert
        assertEquals(valorPrimeiro, valorUltimo);
    }

    @Test
    public void removendoOPrimeiroNodoOQueFicaNoLugarTemValueIlluminati() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Carpinejar");
        lista.addLast("Illuminati");

        String valorEsperado = "Illuminati";

        // Act
        lista.removeFirst();
        String valorObtido = lista.getFirst();

        // Assert
        assertEquals(valorEsperado, valorObtido);
    }

    @Test
    public void removeONodoNaPosiçãoUmEmListaDeTrês() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Ichi");
        lista.addLast("Ni");
        lista.addLast("San");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("San");

        // Act
        lista.remove(1);

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }

    @Test
    public void adicionaUmNodoNaPosiçãoUmEmListaDeTrês() {
        // Arrange
        DoubleLinkedList<String> lista = new DoubleLinkedList<>();
        lista.addLast("Ichi");
        lista.addLast("San");
        lista.addLast("Shi");

        ArrayList<String> listaEsperada = new ArrayList<>();
        listaEsperada.add("Ichi");
        listaEsperada.add("Ni");
        listaEsperada.add("San");
        listaEsperada.add("Shi");

        // Act
        lista.add(1, "Ni");

        List<String> listaObtida = lista.list();

        // Assert
        assertEquals(listaEsperada, listaObtida);
    }
}

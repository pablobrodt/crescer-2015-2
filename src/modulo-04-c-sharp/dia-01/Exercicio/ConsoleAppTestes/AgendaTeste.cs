using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleAPP;
using System.Collections.Generic;

namespace ConsoleAppTestes
{
    [TestClass]
    public class AgendaTeste
    {
        [TestMethod]
        public void AgendaTemUmContato()
        {
            var agenda = new Agenda();
            var contato = new Contato("Julio Cesar", 12345);

            agenda.AdicionarContato(contato);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }

        [TestMethod]
        public void AgendaListaDoisContatos()
        {
            string resultadoEsperado = "Nome: Teste - Numero: 12345\nNome: Carlos - Numero: 54321\n";
            var agenda = new Agenda();
            var contato1 = new Contato("Teste", 12345);
            var contato2 = new Contato("Carlos", 54321);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            string contatos = agenda.ListarContatos();

            Assert.AreEqual(contatos, resultadoEsperado);

        }

        [TestMethod]
        public void AgendaListaDoisContatosOrdenadosPorNome()
        {
            string resultadoEsperado = "Nome: Abraham - Numero: 12345\nNome: Carlos - Numero: 54321\n";
            var agenda = new Agenda();
            var contato2 = new Contato("Carlos", 54321);
            var contato1 = new Contato("Abraham", 12345);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            string contatos = agenda.ListarContatosOrdenadoPorNome();

            Assert.AreEqual(contatos, resultadoEsperado);
        }

        [TestMethod]
        public void AgendaListaDozeContatosOrdenadosPorNome()
        {
            string resultadoEsperado = "Nome: Afrodite de Peixes - Numero: 12\n";
            resultadoEsperado += "Nome: Aiolia de Leão - Numero: 5\n";
            resultadoEsperado += "Nome: Aiolos de Sagitário - Numero: 9\n";
            resultadoEsperado += "Nome: Aldebaran de Touro - Numero: 2\n";
            resultadoEsperado += "Nome: Camus de Aquário - Numero: 11\n";
            resultadoEsperado += "Nome: Dohko de Libra - Numero: 7\n";
            resultadoEsperado += "Nome: Máscara da Morte de Câncer - Numero: 4\n";
            resultadoEsperado += "Nome: Milo de Escorpião - Numero: 8\n";
            resultadoEsperado += "Nome: Mu de Áries - Numero: 1\n";
            resultadoEsperado += "Nome: Saga de Gêmeos - Numero: 3\n";
            resultadoEsperado += "Nome: Shaka de Virgem - Numero: 6\n";
            resultadoEsperado += "Nome: Shura de Capricórnio - Numero: 10\n";
            
            var agenda = new Agenda();

            var contato1 = new Contato("Mu de Áries", 1);
            var contato2 = new Contato("Aldebaran de Touro", 2);
            var contato3 = new Contato("Saga de Gêmeos", 3);
            var contato4 = new Contato("Máscara da Morte de Câncer", 4);
            var contato5 = new Contato("Aiolia de Leão", 5);
            var contato6 = new Contato("Shaka de Virgem", 6);
            var contato7 = new Contato("Dohko de Libra", 7);
            var contato8 = new Contato("Milo de Escorpião", 8);
            var contato9 = new Contato("Aiolos de Sagitário", 9);
            var contato10 = new Contato("Shura de Capricórnio", 10);
            var contato11 = new Contato("Camus de Aquário", 11);
            var contato12 = new Contato("Afrodite de Peixes", 12);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato3);
            agenda.AdicionarContato(contato4);
            agenda.AdicionarContato(contato5);
            agenda.AdicionarContato(contato6);
            agenda.AdicionarContato(contato7);
            agenda.AdicionarContato(contato8);
            agenda.AdicionarContato(contato9);
            agenda.AdicionarContato(contato10);
            agenda.AdicionarContato(contato11);
            agenda.AdicionarContato(contato12);

            string contatos = agenda.ListarContatosOrdenadoPorNome();

            Assert.AreEqual(contatos, resultadoEsperado);
        }

        [TestMethod]
        public void AgendaRemoveDoisContatosPorNumero()
        {   
            var agenda = new Agenda();
            var contato1 = new Contato("Eugene", 54321);
            var contato2 = new Contato("Abraham", 12345);
            var contato3 = new Contato("Rosita", 12345);

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);
            agenda.AdicionarContato(contato2);

            agenda.RemoverContatoPorNumero(12345);

            Assert.AreEqual(agenda.QuantidadeContatos, 1);
        }
    }
}

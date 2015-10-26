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

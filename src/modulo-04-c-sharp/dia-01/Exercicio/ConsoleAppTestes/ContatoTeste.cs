using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using ConsoleAPP;

namespace ConsoleAppTestes
{
    [TestClass]
    public class ContatoTeste
    {
        [TestMethod]
        public void ContatoTemNome()
        {
            var contato = new Contato("Teste", 12345);

            Assert.AreEqual(contato.Nome, "Teste");
        }

        [TestMethod]
        public void ContatoTemNumero()
        {
            var contato = new Contato("Teste", 12345);

            Assert.AreEqual(contato.Numero, 12345);
        }
    }
}

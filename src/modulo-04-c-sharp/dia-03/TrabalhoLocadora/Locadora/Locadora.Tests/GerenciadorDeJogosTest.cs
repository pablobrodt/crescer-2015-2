using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;

namespace Locadora.Tests
{
    [TestClass]
    public class GerenciadorDeJogosTest
    {
        [TestMethod]
        public void BuscaPorNomeChronoTriggerRetornaChronoTrigger()
        {
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogo = gerenciador.pesquisarPorNome("Chrono Trigger")[0];

            Assert.AreEqual(jogo.Nome, "Chrono Trigger");
            Assert.AreEqual(jogo.Preco, 60);
            Assert.AreEqual(jogo.Categoria, "RPG");

        }

        [TestMethod]
        public void BuscaPorNomeFinalRetornaFinalFantasyEFinalFight()
        {
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo[] jogo = gerenciador.pesquisarPorNome("Final");

            Assert.AreEqual("Final Fight", jogo[0].Nome);
            Assert.AreEqual(12, jogo[0].Preco);
            Assert.AreEqual("AVENTURA", jogo[0].Categoria);

            Assert.AreEqual("Final Fantasy VI", jogo[1].Nome);
            Assert.AreEqual(30.5, jogo[1].Preco);
            Assert.AreEqual("RPG", jogo[1].Categoria);
        }
    }
}

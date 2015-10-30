using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using Locadora.Dominio;
using System.Xml.Linq;

namespace Locadora.Tests
{
    [TestClass]
    public class GerenciadorDeJogosTest
    {
        XElement baseTesteOriginal;

        [TestInitialize]
        public void SetUp()
        {
            BaseDeDados.Caminho = @"C:\locadora\tests\testsdb.xml";
            baseTesteOriginal = XElement.Load(BaseDeDados.Caminho);
        }

        [TestCleanup]
        public void TearDown()
        {
            baseTesteOriginal.Save(BaseDeDados.Caminho);
            BaseDeDados.Caminho = @"C:\locadora\game_store.xml";
        }

        [TestMethod]
        public void BuscaPorNomeChronoTriggerRetornaChronoTrigger()
        {   
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
            Jogo jogoEsperado1 = new Jogo(1, "Chrono Trigger", 60, "RPG", true);

            //Act
            Jogo jogoObtido = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Assert
            Assert.AreEqual(jogoEsperado1, jogoObtido);
        }

        [TestMethod]
        public void BuscaPorNomeFinalRetornaFinalFantasyEFinalFight()
        {   
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
            Jogo jogoEsperado1 = new Jogo(10 , "Final Fight", 12, "AVENTURA", true);
            Jogo jogoEsperado2 = new Jogo(15, "Final Fantasy VI", 30.5, "RPG", true);

            //Act
            Jogo[] jogosObtidos = gerenciador.PesquisarPorNome("Final");

            //Assert
            Assert.AreEqual(jogoEsperado1, jogosObtidos[0]);
            Assert.AreEqual(jogoEsperado2, jogosObtidos[1]);
        }
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

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
            Jogo jogoEsperado1 = new Jogo(1, "Chrono Trigger", 60, Categoria.Rpg, true);

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
            Jogo jogoEsperado1 = new Jogo(10 , "Final Fight", 12, Categoria.Aventura, true);
            Jogo jogoEsperado2 = new Jogo(15, "Final Fantasy VI", 30.5, Categoria.Rpg, true);

            //Act
            Jogo[] jogosObtidos = gerenciador.PesquisarPorNome("Final");

            //Assert
            Assert.AreEqual(jogoEsperado1, jogosObtidos[0]);
            Assert.AreEqual(jogoEsperado2, jogosObtidos[1]);
        }

        [TestMethod]
        public void InsereJogoManeiro()
        {   
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
            Jogo jogoEsperado = new Jogo(21,"Jogo Maneiro", 20.5, Categoria.Aventura, true);

            //Act
            gerenciador.InserirNovoJogo("Jogo Maneiro", 20.5, Categoria.Aventura, true);
            Jogo jogoObtido = gerenciador.PesquisarPorNome("Jogo Maneiro")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoObtido);
        }

        [TestMethod]
        public void InsereTresJogosManeiros()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();
            Jogo jogoEsperado1 = new Jogo(21, "Jogo Maneiro 1", 20.5, Categoria.Aventura, true);
            Jogo jogoEsperado2 = new Jogo(22, "Jogo Maneiro 2", 99.9, Categoria.Aventura, true);
            Jogo jogoEsperado3 = new Jogo(23, "Jogo Maneiro 3", 50, Categoria.Aventura, true);

            //Act
            gerenciador.InserirNovoJogo("Jogo Maneiro 1", 20.5, Categoria.Aventura, true);
            gerenciador.InserirNovoJogo("Jogo Maneiro 2", 99.9, Categoria.Aventura, true);
            gerenciador.InserirNovoJogo("Jogo Maneiro 3", 50, Categoria.Aventura, true);

            Jogo jogoObtido1 = gerenciador.PesquisarPorNome("Jogo Maneiro 1")[0];
            Jogo jogoObtido2 = gerenciador.PesquisarPorNome("Jogo Maneiro 2")[1];
            Jogo jogoObtido3 = gerenciador.PesquisarPorNome("Jogo Maneiro 3")[2];

            //Assert
            Assert.AreEqual(jogoEsperado1, jogoObtido1);
            Assert.AreEqual(jogoEsperado2, jogoObtido2);
            Assert.AreEqual(jogoEsperado3, jogoObtido3);
        }
    }
}

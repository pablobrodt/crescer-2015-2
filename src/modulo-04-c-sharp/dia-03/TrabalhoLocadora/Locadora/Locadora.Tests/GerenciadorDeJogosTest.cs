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
            Jogo jogoObtido2 = gerenciador.PesquisarPorNome("Jogo Maneiro 2")[0];
            Jogo jogoObtido3 = gerenciador.PesquisarPorNome("Jogo Maneiro 3")[0];

            //Assert
            Assert.AreEqual(jogoEsperado1, jogoObtido1);
            Assert.AreEqual(jogoEsperado2, jogoObtido2);
            Assert.AreEqual(jogoEsperado3, jogoObtido3);
        }

        [TestMethod]
        public void AlternaDisponibilidadeParaFalse()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogo = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Act
            jogo.Disponibilidade = false;

            gerenciador.AlterarJogo(jogo);

            Jogo jogoEsperado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Assert
            Assert.AreEqual(jogo, jogoEsperado);
        }

        [TestMethod]
        public void AlternaDisponibilidadeParaTrue()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogo = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            jogo.Disponibilidade = false;

            gerenciador.AlterarJogo(jogo);

            //Act
            jogo.Disponibilidade = true;

            gerenciador.AlterarJogo(jogo);

            Jogo jogoEsperado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Assert
            Assert.AreEqual(jogo, jogoEsperado);
        }

        [TestMethod]
        public void AlteraNomeFinalFantasyVIParaFantasiaFinalSeis()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(15, "Fantasia Final Seis", 30.5, Categoria.Rpg, true);

            Jogo finalFantasy = gerenciador.PesquisarPorNome("Final Fantasy VI")[0];

            //Act
            finalFantasy.Nome = "Fantasia Final Seis";

            gerenciador.AlterarJogo(finalFantasy);

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Fantasia Final Seis")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoAlteradoObtido);
        }

        [TestMethod]
        public void AlteraPrecoSunsetRidersPara1000()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(18, "Sunset Riders", 1000, Categoria.Aventura, true);

            Jogo sunsetRiders = gerenciador.PesquisarPorNome("Sunset Riders")[0];

            //Act
            sunsetRiders.Preco = 1000;

            gerenciador.AlterarJogo(sunsetRiders);

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Sunset Riders")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoAlteradoObtido);
        }

        [TestMethod]
        public void AlteraCategoriaDeTopGearParaEsporte()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(2, "Top Gear", 20, Categoria.Esporte, true);

            Jogo topGear = gerenciador.PesquisarPorNome("Top Gear")[0];

            //Act
            topGear.Categoria = Categoria.Esporte;

            gerenciador.AlterarJogo(topGear);

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Top Gear")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoAlteradoObtido);
        }

        [TestMethod]
        public void AlteraJogoContraIIIParaJogoLokoComPreco90CategoriaEsporteEDisponibilidadeFalse()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(17, "Jogo Loko", 90, Categoria.Esporte, false);

            Jogo contraIII = gerenciador.PesquisarPorNome("Contra III")[0];

            //Act
            contraIII.Nome = "Jogo Loko";
            contraIII.Preco = 90;
            contraIII.Categoria = Categoria.Esporte;
            contraIII.Disponibilidade = false;

            gerenciador.AlterarJogo(contraIII);

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Jogo Loko")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoAlteradoObtido);
        }

        [TestMethod]
        public void AlteraMarioKartEMarioRpgParaMarioCorridaMarioLokoPreco1001EPreco1002CategoriaAventuraECategoriaEsporteEDisponibilidadeFalse()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado1 = new Jogo(6, "Mario Corrida", 1001, Categoria.Aventura, false);
            Jogo jogoEsperado2 = new Jogo(11, "Mario Loko", 1002, Categoria.Esporte, false);

            Jogo[] marios = gerenciador.PesquisarPorNome("Mario");
            Jogo marioKart = marios[0];
            Jogo marioRpg = marios[1];

            //Act
            marioKart.Nome = "Mario Corrida";
            marioKart.Preco = 1001;
            marioKart.Categoria = Categoria.Aventura;
            marioKart.Disponibilidade = false;
            
            marioRpg.Nome = "Mario Loko";
            marioRpg.Preco = 1002;
            marioRpg.Categoria = Categoria.Esporte;
            marioRpg.Disponibilidade = false;

            gerenciador.AlterarJogo(marioKart);
            gerenciador.AlterarJogo(marioRpg);

            Jogo[] jogosAlterados = gerenciador.PesquisarPorNome("Mario");

            Jogo jogoObtido1 = jogosAlterados[0];
            Jogo jogoObtido2 = jogosAlterados[1];

            //Assert
            Assert.AreEqual(jogoEsperado1, jogoObtido1);
            Assert.AreEqual(jogoEsperado2, jogoObtido2);
        }
    }
}

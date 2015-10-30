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

        [TestMethod]
        public void AlternaDisponibilidadeParaFalse()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoAntesDeAlterado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            gerenciador.AlterarJogo(jogoAntesDeAlterado.Id);
            
            bool disponibilidadeEsperada = false;

            //Act
            gerenciador.AlternarDisponibilidade();
            gerenciador.PersistirAlteracoes();

            Jogo jogoAlterado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Assert
            Assert.AreEqual(disponibilidadeEsperada, jogoAlterado.Disponibilidade);
        }

        [TestMethod]
        public void AlternaDisponibilidadeParaTrue()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoAntesDeAlterado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            gerenciador.AlterarJogo(jogoAntesDeAlterado.Id);

            gerenciador.AlternarDisponibilidade();

            bool disponibilidadeEsperada = true;

            //Act
            gerenciador.AlternarDisponibilidade();
            gerenciador.PersistirAlteracoes();

            Jogo jogoAlterado = gerenciador.PesquisarPorNome("Chrono Trigger")[0];

            //Assert
            Assert.AreEqual(disponibilidadeEsperada, jogoAlterado.Disponibilidade);
        }

        [TestMethod]
        public void AlteraNomeFinalFantasyVIParaFantasiaFinalSeis()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(15, "Fantasia Final Seis", 30.5, Categoria.Rpg, true);

            Jogo finalFantasy = gerenciador.PesquisarPorNome("Final Fantasy VI")[0];

            gerenciador.AlterarJogo(finalFantasy.Id);

            //Act
            gerenciador.AlterarNomeJogo("Fantasia Final Seis");

            gerenciador.PersistirAlteracoes();

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

            gerenciador.AlterarJogo(sunsetRiders.Id);

            //Act
            gerenciador.AlterarPrecoJogo(1000);

            gerenciador.PersistirAlteracoes();

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

            gerenciador.AlterarJogo(topGear.Id);

            //Act
            gerenciador.AlterarCategoria(Categoria.Esporte);

            gerenciador.PersistirAlteracoes();

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Top Gear")[0];

            //Assert
            Assert.AreEqual(jogoEsperado, jogoAlteradoObtido);
        }

        [TestMethod]
        public void AlteraDisponibilidadeDeMegamanXParaFalse()
        {
            //Arrange
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo jogoEsperado = new Jogo(3, "Megaman X", 40, Categoria.Aventura, false);

            Jogo megamanX = gerenciador.PesquisarPorNome("Megaman X")[0];

            gerenciador.AlterarJogo(megamanX.Id);

            //Act
            gerenciador.AlternarDisponibilidade();

            gerenciador.PersistirAlteracoes();

            Jogo jogoAlteradoObtido = gerenciador.PesquisarPorNome("Megaman X")[0];

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

            gerenciador.AlterarJogo(contraIII.Id);

            //Act
            gerenciador.AlterarNomeJogo("Jogo Loko");

            gerenciador.AlterarPrecoJogo(90);

            gerenciador.AlterarCategoria(Categoria.Esporte);

            gerenciador.AlternarDisponibilidade();

            gerenciador.PersistirAlteracoes();

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
            gerenciador.AlterarJogo(marioKart.Id);
            gerenciador.AlterarNomeJogo("Mario Corrida");
            gerenciador.AlterarPrecoJogo(1001);
            gerenciador.AlterarCategoria(Categoria.Aventura);
            gerenciador.AlternarDisponibilidade();

            gerenciador.AlterarJogo(marioRpg.Id);
            gerenciador.AlterarNomeJogo("Mario Loko");
            gerenciador.AlterarPrecoJogo(1002);
            gerenciador.AlterarCategoria(Categoria.Esporte);
            gerenciador.AlternarDisponibilidade();

            gerenciador.PersistirAlteracoes();

            Jogo[] jogosAlterados = gerenciador.PesquisarPorNome("Mario");

            Jogo jogoObtido1 = jogosAlterados[0];
            Jogo jogoObtido2 = jogosAlterados[1];

            //Assert
            Assert.AreEqual(jogoEsperado1, jogoObtido1);
            Assert.AreEqual(jogoEsperado2, jogoObtido2);
        }
    }
}

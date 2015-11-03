using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.IO;
using Locadora.Dominio;
using System.Collections;
using System.Collections.Generic;

namespace Locadora.Test
{
    [TestClass]
    public class JogoTest
    {
        private const string CAMINHO_DB_XML = "game_store.test.xml";

        [TestInitialize]
        public void Inicializar()
        {
            File.Copy("game_store.xml", CAMINHO_DB_XML);
        }
        
        [TestCleanup]
        public void Clear()
        {
            File.Delete(CAMINHO_DB_XML);
        }

        [TestMethod]
        [ExpectedException(typeof(ArgumentException))]
        public void NaoPodeAtribuirIdParaJogoExistente()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            Jogo jogo = db.BuscarPorId(1);
            jogo.Id = 10;
        }

        [TestMethod]
        public void BuscaPorNomeRetorna4Registros()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            string nomePesquisa = "ma";

            IList<Jogo> jogos = db.BuscarPorNome(nomePesquisa);

            Assert.AreEqual(4, jogos.Count);

            foreach (Jogo jogo in jogos)
            {
                Assert.IsTrue(jogo.Nome.IndexOf(nomePesquisa, StringComparison.InvariantCultureIgnoreCase) >= 0);
            }
        }

        [TestMethod]
        public void BuscarPorId3RetornaUmJogo()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            Jogo jogo = db.BuscarPorId(3);

            Assert.IsNotNull(jogo);
        }

        [TestMethod]
        public void BuscarPorId0NaoRetornaJogo()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            Jogo jogo = db.BuscarPorId(0);

            Assert.IsNull(jogo);
        }

        [TestMethod]
        public void NovoJogoTemId21()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            Jogo novoJogo = new Jogo("Battle Toads", 10, Categoria.AVENTURA);

            db.CadastrarNovoJogo(novoJogo);

            Jogo jogoSalvo = db.BuscarPorId(21);

            Assert.AreEqual(novoJogo, jogoSalvo);
        }

        [TestMethod]
        public void ExcluirJogoComSucesso()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);
            db.ExcluirJogo(1);

            Assert.AreEqual(19, db.BuscarTodos().Count);
        }

        [TestMethod]
        public void AtualizarJogoComSucesso()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);

            string novoNome = "Goof Troop Ultimate";

            Jogo jogo = db.BuscarPorId(1);
            jogo.Nome = novoNome;

            db.AtualizarJogo(jogo);

            Jogo jogoAtualizado = db.BuscarPorId(1);

            Assert.AreEqual(novoNome, jogoAtualizado.Nome);
        }

        [TestMethod]
        public void BuscarTodosRetorna20Registros()
        {
            var db = new BaseDeDados(CAMINHO_DB_XML);

            Assert.AreEqual(20, db.BuscarTodos().Count);
        }
    }
}

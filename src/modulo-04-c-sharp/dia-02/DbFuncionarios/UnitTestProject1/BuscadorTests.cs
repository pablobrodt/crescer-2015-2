using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;
using System.Collections.Generic;
using DbFuncionarios;

namespace DbFuncionariosTest
{
    [TestClass]
    public class BuscadorTests
    {   
        [TestMethod]
        public void BuscadorBuscaTresFuncionariosOrdenadosPorCargo()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios;

            string[] ordemEsperada = { "Analista", "Analista", "Desenvolvedor",
                                       "Desenvolvedor", "Desenvolvedor", "Desenvolvedor",
                                       "Desenvolvedor", "Desenvolvedor", "Desenvolvedor",
                                       "Desenvolvedor", "Gerente" };

            funcionarios = buscador.OrdenadosPorCargo();

            for (int i = 0; i < funcionarios.Count; i++)
            {
                var cargoDoFuncionario = funcionarios[i].Cargo.Titulo;
                var cargoEsperado = ordemEsperada[i];

                Assert.AreEqual(cargoDoFuncionario, cargoEsperado);
            }

        }

        [TestMethod]
        public void BuscadorEncontraUmFuncionarioComNzNonome()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios = buscador.BuscarPorNome("nz");

            int funcionariosEsperados = 1;

            Assert.AreEqual(funcionarios.Count, funcionariosEsperados);
        }

        [TestMethod]
        public void BuscadorEncontraDezFuncionariosComANoNome()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios = buscador.BuscarPorNome("a");

            int funcionariosEsperados = 10;

            Assert.AreEqual(funcionarios.Count, funcionariosEsperados);
        }

        [TestMethod]
        public void BuscadorRetornaCincoFuncionariosDoTurnoManha()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios = buscador.BuscarPorTurno(TurnoTrabalho.Manha);

            int funcionariosEsperados = 5;

            Assert.AreEqual(funcionarios.Count, funcionariosEsperados);
        }

        [TestMethod]
        public void BuscadorRetornaNoveFuncionariosDosTurnosManhaETarde()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios = buscador.BuscarPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Tarde);

            int funcionariosEsperados = 9;

            Assert.AreEqual(funcionarios.Count, funcionariosEsperados);
        }

        [TestMethod]
        public void BuscadorRetornaOnzeFuncionariosDosTurnosManhaTardeENoite()
        {
            Buscador buscador = new Buscador();

            IList<Funcionario> funcionarios = buscador.BuscarPorTurno(TurnoTrabalho.Manha, TurnoTrabalho.Tarde, TurnoTrabalho.Noite);

            int funcionariosEsperados = 11;

            Assert.AreEqual(funcionarios.Count, funcionariosEsperados);
        }

        /*
        private T Cast<T>(Object obj, T tipo)
        {
            return (T)obj;
        }

        [TestMethod]
        public void BuscadorRetornaNomeECargoDeTodosOsFuncionarios()
        {
            Buscador buscador = new Buscador();

            IList<dynamic> funcionarios = buscador.BuscaRapida();

            string[] nomesEsperados = { "Lucas Leal", "Jean Pinzon", "Rafael Benetti",
                                        "Maurício Borges", "Leandro Andreolli", "Felipe Nervo",
                                        "Lucas Kauer", "Eduardo Arnold", "Gabriel Alboy",
                                        "Carlos Henrique", "Margarete Ricardo"};

            string[] cargosEsperados = { "Desenvolvedor", "Desenvolvedor", "Desenvolvedor",
                                         "Desenvolvedor", "Desenvolvedor", "Desenvolvedor",
                                         "Desenvolvedor", "Desenvolvedor", "Analista",
                                         "Analista", "Gerente"};

            for (int i = 0; i < funcionarios.Count; i++)
            {
                var funcionarioAtual = Cast(funcionarios[i], new { Nome = "", TituloCargo = "" });

                Assert.AreEqual(funcionarioAtual.Nome, nomesEsperados[i]);
                Assert.AreEqual(funcionarioAtual.TituloCargo, cargosEsperados[i]);
            }
        }
        */
    }
}

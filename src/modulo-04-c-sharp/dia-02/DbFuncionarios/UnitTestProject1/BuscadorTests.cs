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
    }
}

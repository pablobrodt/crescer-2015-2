﻿using System;
using Microsoft.VisualStudio.TestTools.UnitTesting;

namespace Locadora.Dominio.Test
{
    [TestClass]
    public class JogoTest
    {   
        //TODO: IMPLEMENTAR TESTES PARA TODOS OS RECURSOS DE DOMINIO

        [TestMethod]
        public void JogoADeveSerIgualJogoB()
        {   
            Jogo jogoA = new Jogo(id: 1, clienteLocacao: new Cliente(1));
            Jogo jogoB = new Jogo(id: 1, clienteLocacao: new Cliente(1));

            Assert.AreEqual(jogoA, jogoB);
        }

        [TestMethod]
        public void LocacaoParaClienteTemIdCorreto()
        {
            Jogo jogo = new Jogo();

            jogo.LocarPara(new Cliente(id: 1));

            Assert.AreEqual(1, jogo.ClienteLocacao.Id);
        }
    }
}

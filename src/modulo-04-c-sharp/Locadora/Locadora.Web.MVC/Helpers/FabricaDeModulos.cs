﻿using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Infraestrutura.Servicos;
using Locadora.Repositorio.EF.Repositorios;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Helpers
{
    public class FabricaDeModulos
    {
        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IServicoCriptografia CriarServicoCriptografia()
        {
            return new ServicoCriptografia();
        }

        public static ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(CriarUsuarioRepositorio(), CriarServicoCriptografia());
        }
    }
}
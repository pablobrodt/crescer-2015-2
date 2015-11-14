using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Repositorio.EF;
using Locadora.Servicos.ServicosCriptografia;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Helpers
{
    public class FabricaDeModulos
    {   
        //TODO: REVISAR FABRICA DE MODULOS: SERÁ UMA BOA FRAGMENTAR EM FABRICA DE REPOSITORIOS E FABRICA DE SERVICOS?

        public static IJogoRepositorio CriarJogoRepositorio()
        {
            return new JogoRepositorio();
        }

        public static IUsuarioRepositorio CriarUsuarioRepositorio()
        {
            return new UsuarioRepositorio();
        }

        public static IClienteRepositorio CriarClienteRepositorio()
        {
            return new ClienteRepositorio();
        }

        public static IServicoCriptografia CriarCriptografia()
        {
            return new ServicoCriptografia();
        }

        public static ServicoAutenticacao CriarServicoAutenticacao()
        {
            return new ServicoAutenticacao(CriarUsuarioRepositorio(), CriarCriptografia());
        }

        public static ServicoLocacao CriarServicoLocacao()
        {
            return new ServicoLocacao(CriarJogoRepositorio());
        }
    }
}
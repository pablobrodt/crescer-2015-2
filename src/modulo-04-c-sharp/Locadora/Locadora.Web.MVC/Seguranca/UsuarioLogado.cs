using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioLogado
    {
        public string UserName { get; set; }
        public string NomeCompleto { get; set; }
        public string[] Permissoes { get; set; }

        public UsuarioLogado(string userName, string nomeCompleto, string[] permissoes)
        {
            this.UserName = userName;
            this.NomeCompleto = nomeCompleto;
            this.Permissoes = permissoes;
        }
    }
}
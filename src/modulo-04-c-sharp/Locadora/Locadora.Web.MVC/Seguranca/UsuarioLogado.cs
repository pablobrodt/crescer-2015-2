using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class UsuarioLogado
    {
        public string Email { get; set; }
        public string NomeCompleto { get; set; }
        public string[] Permissoes { get; set; }
        
        public UsuarioLogado(string email, string nomeCompleto, string[] permissoes)
        {
            this.Email = email;
            this.NomeCompleto = nomeCompleto;
            this.Permissoes = permissoes;
        }

        public bool TemPermissao(string nomePermissao)
        {
            return this.Permissoes != null
                && this.Permissoes.Contains(nomePermissao);
        }
    }
}
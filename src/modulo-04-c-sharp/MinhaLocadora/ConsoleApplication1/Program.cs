using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Repositorio.EF;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApplication1
{
    class Program
    {
        static void Main(string[] args)
        {
            IUsuarioRepositorio repo = new UsuarioRepositorio();

            Usuario u = new Usuario();
            u.Email = "usuario@site.com";
            u.NomeCompleto = "Usuario1";
            u.Senha = "teste";
            Permissao p = new Permissao();
            p.Nome = "DetalhesDoJogo";

            u.Permissoes = new Permissao[] { p };

            repo.Criar(u);
        }
    }
}

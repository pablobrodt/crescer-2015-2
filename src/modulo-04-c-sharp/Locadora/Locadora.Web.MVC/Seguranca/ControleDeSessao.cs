using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Security;

namespace Locadora.Web.MVC.Seguranca
{
    public class ControleDeSessao
    {
        private const string USUARIO_LOGADO = "USUARIO_LOGADO";

        public static UsuarioLogado UsuarioLogado
        {
            get
            {
                return HttpContext.Current.Session[USUARIO_LOGADO] as UsuarioLogado;
            }
        }

        public static void CriarSessao(Usuario usuarioAutenticado)
        {
            string email = usuarioAutenticado.Email;
            string nomeCompleto = usuarioAutenticado.NomeCompleto;
            string[] permissoes = usuarioAutenticado.Permissoes.Select(p => p.Nome).ToArray();

            var usuarioLogado = new UsuarioLogado(email, nomeCompleto, permissoes);

            FormsAuthentication.SetAuthCookie(email, true);

            HttpContext.Current.Session["USUARIO_LOGADO"] = usuarioLogado;
        }
    }
}
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Security.Principal;
using System.Threading;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Seguranca
{
    public class Autorizador : AuthorizeAttribute
    {
        public override void OnAuthorization(AuthorizationContext filterContext)
        {
            var httpContext = filterContext.HttpContext;
            var session = httpContext.Session["USUARIO_LOGADO"];

            bool temAutorizacao = AuthorizeCore(httpContext);
            bool temSession = session != null;

            if (temSession && temAutorizacao)
            {
                UsuarioLogado usuarioLogado = session as UsuarioLogado;
                string[] roles = usuarioLogado.Permissoes;

                var identidade = new GenericIdentity(usuarioLogado.UserName);
                var principal = new GenericPrincipal(identidade, roles);

                Thread.CurrentPrincipal = principal;
                HttpContext.Current.User = principal;

                base.OnAuthorization(filterContext);
            }
            else
            {
                HandleUnauthorizedRequest(filterContext);
            }
        }
    }
}
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Repositorio.EF;
using Locadora.Servicos.ServicosCriptografia;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using System.Web.Security;

namespace Locadora.Web.MVC.Controllers
{
    public class LoginController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }

        [HttpPost]
        public ActionResult Login(LoginModel model)
        {
            IUsuarioRepositorio repositorio = new UsuarioRepositorio();

            IServicoCriptografia criptografia = new CriptografiaSHA1();

            var autenticador = new ServicoAutenticacao(repositorio, criptografia);

            Usuario usuario = autenticador.BuscarPorAutenticacao(model.Email, model.Senha);

            if(usuario != null)
            {
                string email = usuario.Email;
                string nomeCompleto = usuario.NomeCompleto;
                string[] permissoes = usuario.Permissoes.Select(p => p.Nome).ToArray();

                var usuarioLogado = new UsuarioLogado(email, nomeCompleto, permissoes);

                FormsAuthentication.SetAuthCookie(email, true);

                Session["USUARIO_LOGADO"] = usuarioLogado;
            }

            return RedirectToAction("Index", "Home");
        }
    }
}
using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio.Servicos;
using Locadora.Repositorio.EF;
using Locadora.Servicos.ServicosCriptografia;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
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

            if (ModelState.IsValid)
            {
                var autenticador = FabricaDeModulos.CriarServicoAutenticacao();

                Usuario usuario = autenticador.BuscarPorAutenticacao(model.Email, model.Senha);

                if (usuario != null)
                {
                    ControleDeSessao.CriarSessao(usuario);

                    return RedirectToAction("Index", "Home");
                }
            }

            ModelState.AddModelError("INVALID_LOGIN", "Usuário ou senha inválidos.");
            return View("Index", model);
        }
    }
}
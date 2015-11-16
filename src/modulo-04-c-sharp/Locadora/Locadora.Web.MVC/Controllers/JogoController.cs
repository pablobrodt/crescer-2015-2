using Locadora.Dominio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using Locadora.Web.MVC.Seguranca;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class JogoController : Controller
    {
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogoEncontrado = FabricaDeModulos.CriarJogoRepositorio().BuscarPorId(id);

            var jogoModel = new DetalheJogoModel(jogoEncontrado);

            return View(jogoModel);
        }
    }
}
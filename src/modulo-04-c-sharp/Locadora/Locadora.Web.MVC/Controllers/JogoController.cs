using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : BaseController
    {
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogoEncontrado = CriarJogoRepositorio().BuscarPorId(id);

            var jogoModel = new DetalheJogoModel(jogoEncontrado);

            return View(jogoModel);
        }
    }
}
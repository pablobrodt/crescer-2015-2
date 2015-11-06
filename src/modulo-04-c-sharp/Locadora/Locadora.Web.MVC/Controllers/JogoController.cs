using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    public class JogoController : Controller
    {
        // GET: Jogo
        public ActionResult DetalhesDoJogo(int id)
        {   
            IJogoRepositorio repositorio = new Locadora.Repositorio.ADO.JogoRepositorio();

            Jogo jogo = repositorio.BuscarPorId(id);

            JogoModel jogoModel = Util.ConverterJogoParaJogoModel(jogo);

            return View(jogoModel);
        }
    }
}
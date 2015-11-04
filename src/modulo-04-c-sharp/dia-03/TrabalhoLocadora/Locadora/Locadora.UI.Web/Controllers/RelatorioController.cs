using Locadora.UI.Web.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.UI.Web.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult JogosDisponiveis()
        {
            var model = new RelatorioModel();

            return View(model);
        }
    }
}
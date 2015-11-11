using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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
        [Autorizador(Roles = "DetalhesDoJogo")]
        [HttpGet]
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogo = ObterJogoPorId(id);

            DetalheJogoModel model = this.JogoToDetalheJogoModel(jogo);

            return View(model);
        }

        [Autorizador(Roles = "ADMIN")]
        [HttpGet]
        public ActionResult Manter(int? id)
        {
            if (id.HasValue)
            {
                Jogo jogo = ObterJogoPorId((int)id);

                var model = this.JogoToManterJogoModel(jogo);

                return View(model);
            }
            else
            {
                return View();
            }
        }

        [Autorizador(Roles = "ADMIN")]
        [HttpPost]
        public ActionResult Salvar(ManterJogoModel model)
        {
            if (ModelState.IsValid)
            {
                Jogo jogo = this.ManterJogoModelToJogo(model);

                if(jogo.Id == 0)
                {
                    this.ObterJogoRepositorio().Criar(jogo);

                    TempData["Mensagem"] = "Jogo inserido com sucesso!";
                }
                else
                {
                    this.ObterJogoRepositorio().Atualizar(jogo);

                    TempData["Mensagem"] = "Jogo atualizado com sucesso!";
                }

                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
            else
            {
                return View("Manter", model);
            }
        }

        private Jogo ObterJogoPorId(int id)
        {
            return this.ObterJogoRepositorio().BuscarPorId(id);
        }
    }
}
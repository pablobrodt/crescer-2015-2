﻿using Locadora.Dominio;
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
        public ActionResult DetalhesDoJogo(int id)
        {
            Jogo jogo = ObterJogoPorId(id);

            DetalheJogoModel model = this.JogoToDetalheJogoModel(jogo);

            return View(model);
        }

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
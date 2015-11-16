using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;
using Locadora.Web.MVC.Seguranca;
using Locadora.Web.MVC.Helpers;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        [Autorizador]
        public ActionResult JogosDisponiveis(string nome)
        {
            IJogoRepositorio repositorio = FabricaDeModulos.CriarJogoRepositorio();

            List<Jogo> jogosDominio = (nome == null) ? repositorio.BuscarTodos().ToList() : repositorio.BuscarPorNome(nome).ToList();

            var model = new RelatorioModel();

            if (jogosDominio.Count > 0)
            {
                foreach (var jogo in jogosDominio)
                {
                    JogoModel jogoModel = this.JogoToJogoModel(jogo);

                    model.Jogos.Add(jogoModel);
                }

                model.QuantidadeTotalJogos = model.Jogos.Count;
            }
            else
            {
                model.QuantidadeTotalJogos = 0;

                ViewBag.Mensagem = "Nenhum jogo encontrado.";
            }

            return View(model);
        }
    }
}
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;
using Locadora.Dominio.Repositorio;
using Locadora.Dominio;

namespace Locadora.Web.MVC.Controllers
{
    public class RelatorioController : Controller
    {
        // GET: Relatorio
        public ActionResult JogosDisponiveis(string nome)
        {
            IJogoRepositorio repositorio = this.ObterJogoRepositorio();

            List<Jogo> jogosDominio = (nome == null) ? repositorio.BuscarTodos().ToList() : repositorio.BuscarPorNome(nome).ToList();

            decimal soma = 0;
            decimal maiorPreco = jogosDominio.Max(jogo => jogo.Preco);
            decimal menorPreco = jogosDominio.Min(jogo => jogo.Preco);

            var model = new RelatorioModel();

            foreach (var jogo in jogosDominio)
            {
                JogoModel jogoModel = this.JogoToJogoModel(jogo);

                soma += jogo.Preco;

                model.Jogos.Add(jogoModel);
            }

            model.QuantidadeTotalJogos = model.Jogos.Count;
            model.ValorMedioJogos = soma / model.QuantidadeTotalJogos;
            model.JogoMaisCaro = model.Jogos.FirstOrDefault(jogo => jogo.Preco == maiorPreco).Nome;
            model.JogoMaisBarato = model.Jogos.FirstOrDefault(jogo => jogo.Preco == menorPreco).Nome;

            return View(model);
        }
    }
}
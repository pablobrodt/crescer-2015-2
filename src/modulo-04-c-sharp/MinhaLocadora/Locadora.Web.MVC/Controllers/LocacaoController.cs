using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
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
    public class LocacaoController : Controller
    {
        public ActionResult Index()
        {
            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }

        [HttpPost]
        [Autorizador(Roles = Permissao.OPERADOR)]
        public ActionResult EfetuarLocacao(EfetuarLocacaoModel efetuarLocacaoModel)
        {
            var repositorioCliente = FabricaDeModulos.CriarClienteRepositorio();
            var repositorioJogo = FabricaDeModulos.CriarJogoRepositorio();
            var servicoLocacao = FabricaDeModulos.CriarServicoLocacao();

            Cliente cliente = repositorioCliente.BuscarPorId(efetuarLocacaoModel.IdCliente);

            Jogo jogo = repositorioJogo.BuscarPorId(efetuarLocacaoModel.idJogo);

            TempData["Mensagem"] = servicoLocacao.EfetuarLocacao(jogo, cliente) > 0 ? "Jogo locado com sucesso!" : "Houve um problema ao locar o jogo.";

            return RedirectToAction("JogosDisponiveis", "Relatorio");
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.OPERADOR)]
        public ActionResult Locar(int? id)
        {
            if (id.HasValue)
            {
                var jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();
                var clienteRepositorio = FabricaDeModulos.CriarClienteRepositorio();

                var jogo = jogoRepositorio.BuscarPorId((int)id);

                LocarJogoModel locarJogoModel = this.JogoToLocarJogoModel(jogo);

                LocarModel locarModel = new LocarModel();
                locarModel.LocarJogoModel = locarJogoModel;
                locarModel.Clientes = this.ListClientesToListClienteModel(clienteRepositorio.BuscarTodos());

                return View(locarModel);
            }
            else
            {
                return RedirectToAction("JogosDisponiveis", "Relatorio");
            }
        }

        [HttpGet]
        [Autorizador(Roles = Permissao.OPERADOR)]
        public ActionResult Devolucao(DevolucaoModel devolucaoModel)
        {   
            if(devolucaoModel == null)
            {
                devolucaoModel = new DevolucaoModel();
            }

            IJogoRepositorio jogoRepositorio = FabricaDeModulos.CriarJogoRepositorio();

            var jogos = jogoRepositorio.BuscarTodos();

            devolucaoModel.Jogos = new List<LocarJogoModel>();

            foreach (var jogo in jogos)
            {
                devolucaoModel.Jogos.Add(this.JogoToLocarJogoModel(jogo));
            }

            if (devolucaoModel.idJogo.HasValue)
            {
                var jogo = jogoRepositorio.BuscarPorId((int)devolucaoModel.idJogo);

                devolucaoModel.LoacarJogoModel = this.JogoToLocarJogoModel(jogo);
            }

            return View(devolucaoModel);
        }
    }
}
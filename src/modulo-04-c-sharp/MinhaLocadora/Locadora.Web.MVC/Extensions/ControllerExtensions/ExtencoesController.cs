using Locadora.Dominio;
using Locadora.Dominio.Repositorio;
using Locadora.Web.MVC.Helpers;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC
{
    public static class ExtencoesController
    {
        public static Jogo ManterJogoModelToJogo(this Controller controller, ManterJogoModel model)
        {
            Jogo jogo = (model.Id.HasValue) ? new Jogo((int)model.Id) : jogo = new Jogo();

            jogo.Nome = model.Nome;
            jogo.Categoria = model.Categoria;
            jogo.Descricao = model.Descricao;
            jogo.Selo = model.Selo;
            jogo.Imagem = model.Imagem;
            jogo.Video = model.Video;
            jogo.DataLocacao = model.DataLocacao;

            return jogo;
        }

        public static JogoModel JogoToJogoModel(this Controller controller, Jogo jogo)
        {
            return new JogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria,
            };
        }

        public static DetalheJogoModel JogoToDetalheJogoModel(this Controller controller, Jogo jogo)
        {
            return new DetalheJogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                Imagem = jogo.Imagem,
                Video = jogo.Video
            };
        }

        public static ManterJogoModel JogoToManterJogoModel(this Controller controller, Jogo jogo)
        {
            return new ManterJogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo,
                Imagem = jogo.Imagem,
                Video = jogo.Video,
                DataLocacao = jogo.DataLocacao
            };
        }

        public static LocarJogoModel JogoToLocarJogoModel(this Controller controller, Jogo jogo)
        {
            LocarJogoModel locarModel = new LocarJogoModel();

            locarModel.Id = jogo.Id;
            locarModel.NomeJogo = jogo.Nome;
            locarModel.Descricao = jogo.Descricao;
            locarModel.Imagem = jogo.Imagem;
            locarModel.DataEntrega = FabricaDeModulos.CriarServicoLocacao().ObterDataPrevistaEntrega(jogo);
            locarModel.Preco = jogo.Preco;
            locarModel.Selo = jogo.Selo;

            return locarModel;
        }

        public static ClienteModel ClienteToClienteModel(Cliente cliente)
        {
            ClienteModel clienteModel = new ClienteModel();

            clienteModel.Id = cliente.Id;
            clienteModel.Nome = cliente.Nome;

            return clienteModel;
        }

        public static IList<ClienteModel> ListClientesToListClienteModel(this Controller controller, IList<Cliente> clientes)
        {
            IList<ClienteModel> listClienteModel = new List<ClienteModel>();

            foreach (var cliente in clientes)
            {
                var clienteModel = new ClienteModel();
                clienteModel.Id = cliente.Id;
                clienteModel.Nome = cliente.Nome;

                listClienteModel.Add(clienteModel);
            }

            return listClienteModel;
        }
    }
}
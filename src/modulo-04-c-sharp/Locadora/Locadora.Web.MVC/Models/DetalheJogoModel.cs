using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DetalheJogoModel
    {
        public int IdJogo { get; private set; }
        public string Nome { get; private set; }
        public decimal Preco { get; private set; }
        public string Categoria { get; private set; }
        public string UrlImagem { get; private set; }
        public string TagVideo { get; private set; }

        public DetalheJogoModel(Jogo jogo)
        {
            this.IdJogo = jogo.Id;
            this.Nome = jogo.Nome;
            this.Preco = jogo.Preco;
            this.Categoria = jogo.Categoria.ToString();
            this.UrlImagem = jogo.UrlImagem;
            this.TagVideo = jogo.TagVideo;
        }
    }
}
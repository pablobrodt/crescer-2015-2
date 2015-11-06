using Locadora.Dominio;
using Locadora.Web.MVC.Models;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC
{
    public class Util
    {
        public static JogoModel ConverterJogoParaJogoModel(Jogo jogo)
        {
            return new JogoModel()
            {
                Id = jogo.Id,
                Nome = jogo.Nome,
                Categoria = jogo.Categoria.ToString(),
                Preco = jogo.Preco,
                Descricao = jogo.Descricao,
                Selo = jogo.Selo.ToString(),
                Imagem = jogo.Imagem,
                Video = jogo.Video
            };
        }
    }
}
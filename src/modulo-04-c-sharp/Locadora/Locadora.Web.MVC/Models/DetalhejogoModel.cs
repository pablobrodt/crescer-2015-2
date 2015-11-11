using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DetalheJogoModel
    {
        public int Id { get; set; }

        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public string Descricao { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }
    }
}
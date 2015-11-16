using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocarJogoModel
    {
        public int Id { get; set; }

        public string NomeJogo { get; set; }

        public string Descricao { get; set; }

        public DateTime DataEntrega { get; set; }

        public decimal Preco { get; set; }

        public string Imagem { get; set; }

        public Selo Selo { get; set; }
    }
}
using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class RelatorioJogosDisponiveisModel
    {
        public List<JogoDisponivelModel> Jogos { get; private set; }

        public int QuantidadeTotalDeJogos { get; private set; }
        public decimal ValorMedio { get; private set; }
        public JogoDisponivelModel JogoMaisCaro { get; private set; }
        public JogoDisponivelModel JogoMaisBarato { get; private set; }

        public RelatorioJogosDisponiveisModel(IList<Jogo> jogosDisponiveis)
        {
            Jogos = new List<JogoDisponivelModel>();

            if(jogosDisponiveis != null && jogosDisponiveis.Count > 0)
            {
                foreach (Jogo jogo in jogosDisponiveis)
                {
                    var jogoModel = new JogoDisponivelModel()
                    {
                        IdJogo = jogo.Id,
                        Nome = jogo.Nome,
                        Preco = jogo.Preco,
                        Categoria = jogo.Categoria.ToString()
                    };

                    this.Jogos.Add(jogoModel);
                }

                QuantidadeTotalDeJogos = jogosDisponiveis.Count;
                ValorMedio = jogosDisponiveis.Average(j => j.Preco);
                decimal maiorPreco = jogosDisponiveis.Max(j => j.Preco);
                decimal menorPreco = jogosDisponiveis.Min(j => j.Preco);

                this.JogoMaisCaro = this.Jogos.First(j => j.Preco == maiorPreco);
                this.JogoMaisBarato = this.Jogos.First(j => j.Preco == menorPreco);
            }
            
        }     
    }    

    public class JogoDisponivelModel
    {
        public int IdJogo { get; set; }
        public string Nome { get; set; }
        public decimal Preco { get; set; }
        public string Categoria { get; set; }
    }
}
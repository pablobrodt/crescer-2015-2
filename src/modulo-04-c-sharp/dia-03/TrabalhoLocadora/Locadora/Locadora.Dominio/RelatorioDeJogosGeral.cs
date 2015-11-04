using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class RelatorioDeJogosGeral : Relatorio
    {
        StringBuilder texto = new StringBuilder();

        //Estatísticas
        public int QuantidadeTotalDeJogos { get; private set; }
        public int QuantidadeDeJogosDisponíveis { get; private set; }
        public double ValorMedioPorJogo { get; private set; }
        public Jogo JogoMaisCaro { get; private set; }
        public Jogo JogoMaisBarato { get; private set; }

        public RelatorioDeJogosGeral()
        {
            Data = DataAtual.ToString("dd/MM/yyyy");
            Hora = DataAtual.ToString("HH:mm:ss");
            Titulo = "Relatório de jogos";

            GerenciadorDeJogos gj = new GerenciadorDeJogos();

            this.Jogos = gj.BuscarTodosJogos();

            GerarEstatísticas();
        }

        private void GerarEstatísticas()
        {
            ObterTotalJogos();
            ObterTotalJogosDisponiveis();
            ObterJogoMaisCaro();
            ObterJogoMaisBarato();
        }

        private void ObterJogoMaisCaro()
        {
            double valorMaisAlto = this.Jogos.Max(jogo => jogo.Preco);
            this.JogoMaisCaro = this.Jogos.FirstOrDefault(jogo => jogo.Preco == valorMaisAlto);
        }

        private void ObterJogoMaisBarato()
        {
            double valorMaisBaixo = this.Jogos.Min(jogo => jogo.Preco);
            this.JogoMaisBarato = this.Jogos.FirstOrDefault(jogo => jogo.Preco == valorMaisBaixo);
        }

        private void ObterTotalJogosDisponiveis()
        {
            this.QuantidadeDeJogosDisponíveis = this.Jogos.Count(jogo => jogo.Disponibilidade);
        }

        private void ObterTotalJogos()
        {
            this.QuantidadeTotalDeJogos = this.Jogos.Count();
        }

    }
}
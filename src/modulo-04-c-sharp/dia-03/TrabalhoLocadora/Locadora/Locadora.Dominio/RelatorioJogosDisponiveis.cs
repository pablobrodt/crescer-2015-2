using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class RelatorioJogosDisponiveis : Relatorio
    {   
        public int QuantidadeJogosDisponiveis { get; private set; }

        public RelatorioJogosDisponiveis()
        {
            Data = DataAtual.ToString("dd/MM/yyyy");
            Hora = DataAtual.ToString("HH:mm:ss");
            Titulo = "Relatório de jogos";

            GerenciadorDeJogos gj = new GerenciadorDeJogos();

            this.Jogos = gj.BuscarJogosDisponiveis();

            ObterTotalJogosDisponiveis();
        }

        private void ObterTotalJogosDisponiveis()
        {
            this.QuantidadeJogosDisponiveis = this.Jogos.Count();
        }
    }
}

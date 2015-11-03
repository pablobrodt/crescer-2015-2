using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class RelatorioDeJogos : Relatorio
    {
        List<Jogo> jogos;
        StringBuilder texto = new StringBuilder();

        //Header
        private string Data = DataAtual.ToString("dd/MM/yyyy");
        private string Hora = DataAtual.ToString("HH:mm:ss");
        private string titulo = "Relatório de jogos";

        //Estatísticas
        int QuantidadeTotalDeJogos { get; set; }
        int QuantidadeDeJogosDisponíveis { get; set; }
        double ValorMedioPorJogo { get; set; }
        Jogo MaisCaro { get; set; }
        Jogo MaisBarato { get; set; }

        public RelatorioDeJogos(List<Jogo> jogos)
        {
            this.jogos = jogos;
        }

        private void gerarCabecalho()
        {
            texto.AddSpaces(29);
            texto.Append(nomeLocadora);
            texto.AddSpaces(31);
            texto.BreakLine();

            texto.Append(Data);
            texto.AddSpaces(62);
            texto.Append(Hora);
            texto.BreakLine();

            texto.AddSpaces(30);
            texto.Append(titulo);
            texto.AddSpaces(32);
            texto.BreakLine();

            texto.AddHorizontalSeparator(80, "=");

            texto.BreakLine();
        }

        private int CalcularEspacos(int maximo, int tamanhoString)
        {
            return maximo - tamanhoString;
        }

        private string TruncString(string palavra)
        {
            return palavra.Length > 27 ? palavra.Substring(0, 26) + "..." : palavra;
        }

        private string BoolToString(bool booleano)
        {
            return booleano ? "SIM" : "NAO";
        }

        private void gerarDados()
        {
            texto.Append("ID");
            texto.AddSpaces(7);
            texto.Append("Categoria");
            texto.AddSpaces(8);
            texto.Append("Nome");
            texto.AddSpaces(26);
            texto.Append("Preço");
            texto.AddSpaces(9);
            texto.Append("Disponivel");

            texto.BreakLine();

            foreach (Jogo jogo in jogos)
            {
                int idLength = jogo.Id.ToString().Length;
                int categoriaLength = jogo.Categoria.ToString().Length;
                int nomeLength = TruncString(jogo.Nome).Length;
                int precoLength = jogo.Preco.ToString().Length;
                int disponibilidadeLength = BoolToString(jogo.Disponibilidade).Length;

                texto.Append(jogo.Id);
                texto.AddSpaces(CalcularEspacos(9, idLength));

                texto.Append(jogo.Categoria.ToString());
                texto.AddSpaces(CalcularEspacos(17, categoriaLength));

                texto.Append(TruncString(jogo.Nome));
                texto.AddSpaces(CalcularEspacos(30, nomeLength));

                texto.Append("R$ " + jogo.Preco.ToString());
                texto.AddSpaces(CalcularEspacos(18, precoLength));

                texto.Append(BoolToString(jogo.Disponibilidade));

                texto.BreakLine();
            }
        }

        private void gerarEstatisticas()
        {
            texto.AddHorizontalSeparator(80, "-");

            texto.BreakLine();

            int disponiveis = 0;
            double somaPrecos = 0;

            foreach (Jogo jogo in jogos)
            {
                disponiveis = jogo.Disponibilidade ? disponiveis + 1 : disponiveis;
                somaPrecos += jogo.Preco; 
            }

            string totalJogos = "Quantidade total de jogos: " + this.jogos.Count;

            string jogosDisponiveis = "Quantidade de jogos disponiveis: " + disponiveis;

            string mediaPrecos = "Valor médio por jogo: " + somaPrecos / this.jogos.Count;

            double valorMaisAlto = this.jogos.Max(jogo => jogo.Preco);
            string jogoMaisCaro = "Jogo mais caro: " + this.jogos.FirstOrDefault(jogo => jogo.Preco == valorMaisAlto).Nome;

            double valorMaisBaixo = this.jogos.Min(jogo => jogo.Preco);
            string jogoMaisBarato = "Jogo mais barato: " + this.jogos.FirstOrDefault(jogo => jogo.Preco == valorMaisBaixo).Nome; ;

            texto.Append(totalJogos);
            texto.BreakLine();

            texto.Append(jogosDisponiveis);
            texto.BreakLine();

            texto.Append(mediaPrecos);
            texto.BreakLine();

            texto.Append(jogoMaisCaro);
            texto.BreakLine();

            texto.Append(jogoMaisBarato);
            texto.BreakLine();
        }
        
        private void gerarRodape()
        {
            texto.AddHorizontalSeparator(80, "=");
        }

        public void gerarRelatorio()
        {
            gerarCabecalho();
            gerarDados();
            gerarEstatisticas();
            gerarRodape();

            using (StreamWriter writer = new StreamWriter(@"C:\locadora\relatorioteste.txt"))
            {
                writer.Write(texto);

            }
        }
    }
}
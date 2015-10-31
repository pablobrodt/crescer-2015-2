using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class GerenciadorDeRelatorios
    {
        public void GerarRelatorioDeJogos()
        {
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            Jogo[] lista = gerenciador.PesquisarPorNome("");

            RelatorioDeJogos relatorio = new RelatorioDeJogos(lista.ToList());

            relatorio.gerarRelatorio();
        }
    }
}

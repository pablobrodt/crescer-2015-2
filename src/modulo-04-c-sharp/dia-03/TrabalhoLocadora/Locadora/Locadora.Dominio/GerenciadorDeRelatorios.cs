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
        public RelatorioDeJogosGeral ObterRelatorioDeJogosGeral()
        {
            return new RelatorioDeJogosGeral();
        }

        public RelatorioJogosDisponiveis ObterRelatorioJogosDisponiveis()
        {
            return new RelatorioJogosDisponiveis();
        }
    }
}

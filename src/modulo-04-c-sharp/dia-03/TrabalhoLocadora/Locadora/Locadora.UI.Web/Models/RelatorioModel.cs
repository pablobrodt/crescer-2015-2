using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.UI.Web.Models
{
    public class RelatorioModel
    {
        private GerenciadorDeRelatorios gerenciador;

        public RelatorioModel()
        {
            this.gerenciador = new GerenciadorDeRelatorios();
        }

        public RelatorioDeJogosGeral Relatorio()
        {
            return gerenciador.ObterRelatorioDeJogosGeral();
        }
    }
}
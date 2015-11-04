using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.UI.Web.Models
{
    public class JogoModel
    {   
        public Jogo[] jogos { get; }

        public JogoModel()
        {
            GerenciadorDeJogos gerenciador = new GerenciadorDeJogos();

            this.jogos = gerenciador.BuscarTodosJogos();
        }
    }
}
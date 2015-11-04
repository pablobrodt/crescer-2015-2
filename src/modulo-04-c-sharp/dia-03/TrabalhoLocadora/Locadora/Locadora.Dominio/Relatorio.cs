using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public abstract class Relatorio
    {
        protected string nomeLocadora = "LOCADORA NUNES GAMES";
        protected DateTime DataAtual = DateTime.Now;
        public Jogo[] Jogos { get; protected set; }
        public string Data { get; protected set; }
        public string Hora { get; protected set; }
        public string Titulo { get; protected set; }
    }
}

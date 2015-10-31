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
        protected static DateTime DataAtual = DateTime.Now;
    }
}

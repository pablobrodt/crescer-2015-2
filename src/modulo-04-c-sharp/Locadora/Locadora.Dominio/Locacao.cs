using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Locacao : EntidadeBase
    {
        public Cliente Cliente { get; set; }

        public Jogo Jogo { get; set; }

        public DateTime DataLocacao { get; set; }

        public DateTime DataDevolucao { get; set; }

        public Locacao()
        {
                
        }

        public Locacao(int id)
        {
            this.Id = id;
        }

        public Locacao(Jogo jogo, Cliente cliente)
        {
            this.Jogo = jogo;
            this.Cliente = cliente;
            this.DataLocacao = DateTime.Now;
        }
    }
}

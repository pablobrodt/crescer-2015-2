using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Cliente : EntidadeBase
    {
        public string Nome { get; set; }

        //TODO: VERIFICAR RELACIONAMENTO ENTRE CLIENTE E JOGO
        public ICollection<Jogo> JogosLocados { get; set; }

        public bool PodeLocar { get { return JogosLocados.Count < 3; } }

        public Cliente()
        {
            this.JogosLocados = new List<Jogo>();
        }

        public Cliente(int id) : this()
        {
            this.Id = id;
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio
{
    public class Jogo
    {
        public string Nome { get; set; }
        public double Preco { get; set; }
        public string Categoria { get; set; }
        public bool Disponibilidade { get; set; }

        public Jogo(string nome, double preco, string categoria, bool disponibilidade)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
            this.Disponibilidade = disponibilidade;
        }
    }
}

using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Jogo
    {   
        public int Id { get; }
        public string Nome { get; set; }
        public double Preco { get; set; }
        public string Categoria { get; set; }
        public bool Disponibilidade { get; set; }


        public Jogo(int id, string nome, double preco, string categoria, bool disponibilidade) : this(nome, preco, categoria, disponibilidade)
        {
            this.Id = id;
        }

        public Jogo(string nome, double preco, string categoria, bool disponibilidade)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
            this.Disponibilidade = disponibilidade;
        }


        public XElement ToXElement()
        {
            XElement jogo = new XElement("Jogo");

            jogo.SetAttributeValue("id", Id);

            XElement nome = new XElement("Nome", this.Nome);

            XElement preco = new XElement("Preco", this.Preco);

            XElement categoria = new XElement("Categoria", this.Categoria);

            XElement disponibilidade = new XElement("Disponibilidade", this.Disponibilidade);

            
            jogo.Add(nome);
            jogo.Add(preco);
            jogo.Add(categoria);
            jogo.Add(disponibilidade);

            return jogo;
        }

    }
}

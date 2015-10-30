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
        public Categoria Categoria { get; set; }
        public bool Disponibilidade { get; set; }


        public Jogo(int id, string nome, double preco, Categoria categoria, bool disponibilidade) : this(nome, preco, categoria, disponibilidade)
        {
            this.Id = id;
        }

        public Jogo(string nome, double preco, Categoria categoria, bool disponibilidade)
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

            XElement categoria = new XElement("Categoria", this.Categoria.ToString());

            XElement disponibilidade = new XElement("Disponibilidade", this.Disponibilidade);

            jogo.Add(nome);
            jogo.Add(preco);
            jogo.Add(categoria);
            jogo.Add(disponibilidade);

            return jogo;
        }

        public override bool Equals(Object obj)
        {
            Jogo comparado = (Jogo)obj;

            bool idIgual = (comparado.Id == this.Id);
            bool nomeIgual = (comparado.Nome == this.Nome);
            bool precoIgual = (comparado.Preco == this.Preco);
            bool categoriaIgual = (comparado.Categoria == this.Categoria);
            bool disponibilidadeIgual = (comparado.Disponibilidade == this.Disponibilidade);

            bool resultado = (idIgual && nomeIgual && precoIgual && categoriaIgual && disponibilidadeIgual);

            return resultado;
        }

    }
}

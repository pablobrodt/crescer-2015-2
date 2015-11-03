using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo
    {
        private int _id = 0;
        public int Id
        {
            get { return this._id; }
            set
            {
                if(this._id > 0)
                {
                    throw new ArgumentException("Este jogo já possui um ID.");
                }

                this._id = value;
            }
        }

        public string Nome { get; set; }

        public double Preco { get; set; }

        public Categoria Categoria { get; set; }

        public Jogo()
        {
        }

        public Jogo(string nome, double preco, Categoria categoria)
        {
            this.Nome = nome;
            this.Preco = preco;
            this.Categoria = categoria;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Preço: " + this.Preco.ToString("C", CultureInfo.GetCultureInfo("pt-BR")));
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }
    }
}

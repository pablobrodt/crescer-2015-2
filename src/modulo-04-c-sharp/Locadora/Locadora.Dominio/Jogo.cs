using System;
using System.Globalization;
using System.Text;

namespace Locadora.Dominio
{
    public class Jogo : EntidadeBase
    {
        public string Nome { get; set; }

        public Categoria Categoria { get; set; }

        public Cliente ClienteLocacao { get; set; }

        public DateTime? DataLocacao { get; set; }

        public string Descricao { get; set; }

        public Selo Selo { get; set; }

        public string Imagem { get; set; }

        public string Video { get; set; }

        public bool PodeSerLocado { get { return ClienteLocacao == null && DataLocacao == null; } }

        public double DiasLocacao
        {
            get { return GetDiasLocacao(); }
        }

        public decimal Preco
        {
            get { return GetPreco(); }
        }

        public Jogo()
        {

        }

        public Jogo(int id, Cliente clienteLocacao = null)
        {
            this.Id = id;
            this.ClienteLocacao = clienteLocacao;
        }

        public void LocarPara(Cliente cliente)
        {
            this.ClienteLocacao = cliente;
        }

        private decimal GetPreco()
        {
            decimal preco;

            switch (this.Selo)
            {
                case Selo.OURO: preco = 15;
                    break;
                case Selo.PRATA: preco = 10;
                    break;
                case Selo.BRONZE:  preco = 5;
                    break;
                default:  preco = 0;
                    break;
            }

            return preco;
        }

        private double GetDiasLocacao()
        {
            double dias;

            switch (this.Selo)
            {
                case Selo.OURO: dias = 1;
                    break;
                case Selo.PRATA: dias = 2;
                    break;
                case Selo.BRONZE: dias = 3;
                    break;
                default: dias = 0;
                    break;
            }

            return dias;
        }

        public override string ToString()
        {
            var builder = new StringBuilder();
            builder.AppendLine("Id: " + this.Id);
            builder.AppendLine("Nome: " + this.Nome);
            builder.AppendLine("Categoria: " + this.Categoria);

            return builder.ToString();
        }

        public override int GetHashCode()
        {
            return base.GetHashCode();
        }

        public override bool Equals(object obj)
        {
            if (obj.GetType() == typeof(Jogo))
            {
                Jogo jogoComp = (Jogo)obj;

                return this.Id == jogoComp.Id
                    && this.Nome == jogoComp.Nome
                    && this.Categoria == jogoComp.Categoria
                    && this.ClienteLocacao.Id == jogoComp.ClienteLocacao.Id;
            }

            return false;
        }
    }
}

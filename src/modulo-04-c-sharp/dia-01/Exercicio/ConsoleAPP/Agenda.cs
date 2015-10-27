using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleAPP
{
    public class Agenda
    {
        private List<Contato> contatos;

        public int QuantidadeContatos { get { return contatos.Count; } }

        public Agenda()
        {
            this.contatos = new List<Contato>();
        }

        public void AdicionarContato( Contato contato)
        {
            this.contatos.Add(contato);
        }

        public void RemoverContatoPorNome( string nomeContato )
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (var i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Nome == nomeContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }

        }

        public void RemoverContatoPorNumero(int numeroContato)
        {
            var contatosASeremRemovidos = new List<Contato>();

            for (var i = 0; i < contatos.Count; i++)
            {
                if (contatos[i].Numero == numeroContato)
                {
                    contatosASeremRemovidos.Add(contatos[i]);
                }
            }

            foreach (var contato in contatosASeremRemovidos)
            {
                contatos.Remove(contato);
            }

        }

        public string ListarContatos()
        {
            return ListarContatos(contatos);
        }

        private string ListarContatos(List<Contato> contatos)
        {
            var retornoContatos = new StringBuilder();

            foreach (var contato in contatos)
            {
                retornoContatos.Append("Nome: ");
                retornoContatos.Append(contato.Nome);
                retornoContatos.Append(" - ");
                retornoContatos.Append("Numero: ");
                retornoContatos.Append(contato.Numero);
                retornoContatos.Append("\n");
            }

            return retornoContatos.ToString();
        }

        public string ListarContatosOrdenadoPorNome()
        {
            var contatosOrdenados = new List<Contato>(contatos);

            Contato temp;

            for (var i = 0; i < contatosOrdenados.Count; i++)
            {
                for (var j = 0; j < contatosOrdenados.Count - 1; j++)
                {
                    if (String.Compare(contatosOrdenados[j].Nome, contatosOrdenados[j + 1].Nome) >= 0)
                    {
                        temp = contatosOrdenados[j];
                        contatosOrdenados[j] = contatosOrdenados[j + 1];
                        contatosOrdenados[j + 1] = temp;
                    }
                }   
            }

            return ListarContatos(contatosOrdenados);
        }   

    }
}

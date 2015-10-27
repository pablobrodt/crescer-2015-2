using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAPP
{
    class Menu
    {

        public const int SAIR = 0;
        public const int INSERIR = 1;
        public const int REMOVER_POR_NOME = 2;
        public const int REMOVER_POR_NUMERO = 3;
        public const int LISTAR = 4;
        public const int LISTAR_ORDENADO = 5;
        public const int LIMPAR_TELA = 6;

        private Agenda agenda;

        public Menu(Agenda agenda)
        {
            this.agenda = agenda;
        }

        public void showMenu()
        {
            Console.WriteLine("Escolha sua operação no menu abaixo:");
            Console.WriteLine("1 - INSERIR CONTATO");
            Console.WriteLine("2 - REMOVER CONTATOS POR NOME");
            Console.WriteLine("3 - REMOVER CONTATOS POR NUMERO");
            Console.WriteLine("4 - LISTAR CONTATOS");
            Console.WriteLine("5 - LISTAR CONTATOS ORDENANDO A-Z");
            Console.WriteLine("6 - LIMPAR TELA");
            Console.WriteLine("0 - SAIR");
        }


        public void inserirContato()
        {
            var quantidadeContatosAnterior = agenda.QuantidadeContatos;

            Console.WriteLine("Informe o nome:");
            var nome = Console.ReadLine();

            Console.WriteLine("Informe o número:");
            var numero = int.Parse(Console.ReadLine());

            var contato = new Contato(nome, numero);

            agenda.AdicionarContato(contato);

            var confirmacao = (quantidadeContatosAnterior < agenda.QuantidadeContatos) ? "Adicionado com sucesso!" : "Houve um problema ao adicionar o contato.";

            Console.WriteLine(confirmacao);
        }

        public void removerContato(int criterio)
        {
            var quantidadeContatosAnterior = agenda.QuantidadeContatos;

            if (criterio == REMOVER_POR_NOME)
            {
                Console.WriteLine("Informe o nome:");
                var nome = Console.ReadLine();

                agenda.RemoverContatoPorNome(nome);
            }

            if (criterio == REMOVER_POR_NUMERO)
            {
                Console.WriteLine("Informe o número:");
                var numero = int.Parse(Console.ReadLine());

                agenda.RemoverContatoPorNumero(numero);
            }

            var confirmacao = (quantidadeContatosAnterior > agenda.QuantidadeContatos) ? "Contatos removidos com sucesso!" : "Houve um erro ao remover os contatos";

            Console.WriteLine(confirmacao);
        }

        public void listar(int criterio)
        {
            if (criterio == LISTAR)
            {
                Console.WriteLine(agenda.ListarContatos());
            }

            if (criterio == LISTAR_ORDENADO)
            {
                Console.WriteLine(agenda.ListarContatosOrdenadoPorNome());
            }
        }
    }
}

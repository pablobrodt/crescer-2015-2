using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAPP
{
    class Main
    {
        private Boolean continua = true;
        private Menu menu;
        private Agenda agenda = new Agenda();

        public const int SAIR = 0;
        public const int INSERIR = 1;
        public const int REMOVER_POR_NOME = 2;
        public const int REMOVER_POR_NUMERO = 3;
        public const int LISTAR = 4;
        public const int LISTAR_ORDENADO = 5;
        public const int LIMPAR_TELA = 6;

        public Main()
        {
            menu = new Menu(agenda);
            iniciar();
        }

        public void iniciar()
        {
            showWelcome();

            while (continua)
            {
                menu.showMenu();

                var operacao = int.Parse(Console.ReadLine());

                switch (operacao)
                {
                    case SAIR: continua = false;
                        break;

                    case INSERIR: menu.inserirContato();
                        break;

                    case REMOVER_POR_NOME: menu.removerContato(REMOVER_POR_NOME);
                        break;

                    case REMOVER_POR_NUMERO: menu.removerContato(REMOVER_POR_NUMERO);
                        break;

                    case LISTAR: menu.listar(LISTAR);
                        break;

                    case LISTAR_ORDENADO: menu.listar(LISTAR_ORDENADO);
                        break;

                    case LIMPAR_TELA: Console.Clear();
                        break;
                }
            }
        }

        public void showWelcome()
        {
            Console.WriteLine("Bem vindo ao ConsoleApp :: Agenda!");
        }

        
    }
}

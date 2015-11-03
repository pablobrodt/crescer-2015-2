using Locadora.UI.CadastroDeJogo;
using System;
using System.Collections.Generic;

namespace Locadora.UI
{
    class MenuPrincipal : TelaBase
    {
        private Dictionary<int, string> menus;

        public MenuPrincipal()
        {
            menus = new Dictionary<int, string>();
            menus.Add(1, "Cadastrar Novo Jogo");
            menus.Add(2, "Pesquisar Jogo");
            menus.Add(3, "Imprimir Relatório");
        }

        public override string Titulo
        {
            get
            {
                return "Menu Principal";
            }
        }

        protected override void Iniciar()
        {
            MostrarMenu();
            int menuEscolhido = EscolherMenu();
            AbrirMenu(menuEscolhido);
        }

        private int EscolherMenu()
        {
            int menuEscolhido = 0;

            while (true)
            {
                string escolhaUsuario = LerDados("Escolha");
                if (int.TryParse(escolhaUsuario, out menuEscolhido))
                {
                    if (menus.ContainsKey(menuEscolhido))
                    {
                        return menuEscolhido;
                    }
                }

                ImprimirErro("Escolha inválida...");
                Exibir();
            }
        }

        private void MostrarMenu()
        {
            foreach (var m in menus)
            {
                Console.WriteLine(String.Format("{0} - {1}", m.Key, m.Value));
            }
        }

        private void AbrirMenu(int menuEscolhido)
        {
            switch (menuEscolhido)
            {
                case 1:
                    new MenuCadastrarNovoJogo().Exibir();
                    break;
                case 2:
                    new MenuPesquisarJogo().Exibir();
                    break;
                case 3:
                    new MenuRelatorio().Exibir();
                    break;
                default:
                    break;
            }
        }

    }
}

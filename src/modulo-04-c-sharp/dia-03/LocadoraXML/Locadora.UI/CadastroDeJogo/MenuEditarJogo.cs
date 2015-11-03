using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.UI.CadastroDeJogo
{
    class MenuEditarJogo : MenuDeJogo
    {
        private Jogo jogoEmEdicao;

        public override string Titulo
        {
            get
            {
                return "Editar jogo " + jogoEmEdicao.Nome;
            }
        }

        public MenuEditarJogo(Jogo jogoParaEditar)
        {
            this.jogoEmEdicao = jogoParaEditar;
        }

        protected override void Iniciar()
        {
            Console.WriteLine(jogoEmEdicao);
            Console.WriteLine();

            AtualizarDadosDoJogo(jogoEmEdicao);
            SalvarJogo(jogoEmEdicao);
        }

        protected override void SalvarJogo(Jogo jogo)
        {
            var db = new BaseDeDados();
            db.AtualizarJogo(jogo);

            ImprimirMensagem("Jogo salvo com sucesso.");
        }
    }
}

using Locadora.Dominio;

namespace Locadora.UI.CadastroDeJogo
{
    class MenuCadastrarNovoJogo : MenuDeJogo
    {
        private Jogo novoJogo = new Jogo();

        public override string Titulo
        {
            get
            {
                return "Cadastrar novo Jogo";
            }
        }

        protected override void Iniciar()
        {
            AtualizarDadosDoJogo(novoJogo);
            SalvarJogo(novoJogo);
        }

        protected override void SalvarJogo(Jogo jogo)
        {
            var db = new BaseDeDados();
            db.CadastrarNovoJogo(jogo);

            ImprimirMensagem("Jogo cadastrado com sucesso.");
        }
    }
}

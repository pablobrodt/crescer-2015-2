using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading;
using System.Threading.Tasks;

namespace Locadora.UI
{
    abstract class TelaBase
    {
        private const int TEMPO_MENSAGEM = 3000;

        public abstract string Titulo { get; }

        protected void ImprimirMensagem(string mensagem)
        {
            Console.WriteLine();
            Console.WriteLine("INFO :: " + mensagem);
            Thread.Sleep(TEMPO_MENSAGEM);
        }

        protected void ImprimirErro(string mensagem)
        {
            Console.WriteLine();
            Console.WriteLine("ERRO :: " + mensagem);

            Thread.Sleep(TEMPO_MENSAGEM);
        }

        protected string LerDados(string info)
        {
            Console.Write(info + ": ");
            return Console.ReadLine();
        }

        public void Exibir()
        {
            Console.Clear();
            ImprimirTitulo();
            Iniciar();
        }

        protected abstract void Iniciar();


        private void ImprimirTitulo()
        {
            Console.WriteLine(String.Format("===== {0} =====", Titulo));
        }

    }
}

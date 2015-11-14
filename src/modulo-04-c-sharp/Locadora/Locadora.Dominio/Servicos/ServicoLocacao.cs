using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoLocacao
    {
        private const int NAO_FOI_POSSIVEL_LOCAR = 0;

        private IJogoRepositorio JogoRepositorio { get; set; }

        public ServicoLocacao(IJogoRepositorio repositorio)
        {
            this.JogoRepositorio = repositorio;
        }

        //TODO: FINALIZAR IMPLEMENTAÇAO DE SERVIÇO
        public int EfetuarLocacao(Jogo jogo, Cliente cliente)
        {
            if(cliente.PodeLocar && jogo.PodeSerLocado)
            {
                jogo.ClienteLocacao = cliente;
                jogo.DataLocacao = DateTime.Now;
                cliente.JogosLocados.Add(jogo);

                return JogoRepositorio.Atualizar(jogo);
            }
            else
            {
                return NAO_FOI_POSSIVEL_LOCAR;
            }
        }

        public DateTime ObterDataPrevistaEntrega(Jogo jogo)
        {
            if(jogo.DataLocacao.HasValue)
            {
                return jogo.DataLocacao.Value.AddDays(jogo.DiasLocacao);
            }
            else
            {
                return DateTime.Now.AddDays(jogo.DiasLocacao);
            }
        }


    }
}

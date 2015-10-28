using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;
using System.Xml.Serialization;

namespace Locadora.Dominio
{
    public class GerenciadorDeJogos
    {
        public List<Jogo> jogos = new List<Jogo>();

        public GerenciadorDeJogos()
        {
            this.jogos = new List<Jogo>();
        }

        public Jogo[] pesquisarPorNome(string nomeJogo)
        {

            XElement[] jogosPesquisados = XElement.Load(BaseDeDados.Caminho).Elements("jogo").Where(jogo => jogo.Element("nome").Value.Contains(nomeJogo)).ToArray();

            foreach (XElement jogo in jogosPesquisados)
            {
                string nome = jogo.Element("nome").Value;
                double preco = XmlConvert.ToDouble(jogo.Element("preco").Value);
                string categoria = jogo.Element("categoria").Value;
                bool disponibilidade = true;

                var objJogo = new Jogo(nome, preco, categoria, disponibilidade);

                jogos.Add(objJogo);
            }
            
            return this.jogos.ToArray();
        }

    }
}

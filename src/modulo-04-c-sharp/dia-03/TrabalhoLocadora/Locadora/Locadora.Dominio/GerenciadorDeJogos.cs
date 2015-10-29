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
        public Jogo[] pesquisarPorNome(string titulo)
        {
            XElement[] jogosPesquisados = XElement.Load(BaseDeDados.Caminho).Elements("Jogo").Where(jogo => jogo.Element("Nome").Value.Contains(titulo)).ToArray();

            foreach (XElement jogo in jogosPesquisados)
            {
                string nome = jogo.Element("Nome").Value;
                double preco = XmlConvert.ToDouble(jogo.Element("Preco").Value);
                string categoria = jogo.Element("Categoria").Value;
                bool disponibilidade = XmlConvert.ToBoolean(jogo.Element("Disponibilidade").Value);

                var objJogo = new Jogo(nome, preco, categoria, disponibilidade);

                jogos.Add(objJogo);
            }
            
            return this.jogos.ToArray();
        }

    }
}

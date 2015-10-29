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

        public void inserirNovoJogo(string titulo, double preco, string categoria, bool disponibilidade)
        {
            int id = obterUltimoId() + 1;

            var jogo = new Jogo(id, titulo, preco, categoria, disponibilidade);

            XElement jogosDaBase = XElement.Load(BaseDeDados.Caminho);

            jogosDaBase.Add(jogo.ToXElement());

            jogosDaBase.Save(BaseDeDados.Caminho);
        }

        private int obterUltimoId()
        {
            int ultimoId;

            try
            {
                ultimoId = XmlConvert.ToInt32(XElement.Load(BaseDeDados.Caminho).Elements("Jogo").Attributes().Last().Value);
            }
            catch (InvalidOperationException e)
            {
                ultimoId = 0;
            }
            
            return ultimoId;
        }

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

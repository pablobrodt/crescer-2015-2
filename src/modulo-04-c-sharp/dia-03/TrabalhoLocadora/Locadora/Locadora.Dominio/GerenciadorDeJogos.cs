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
        XElement dadosDoArquivoXml;

        private void CarregarDadosDoXml()
        {
            dadosDoArquivoXml = XElement.Load(BaseDeDados.Caminho);
        }

        private void SalvarXml()
        {
            dadosDoArquivoXml.Save(BaseDeDados.Caminho);
        }

        public void InserirNovoJogo(string titulo, double preco, Categoria categoria, bool disponibilidade)
        {
            CarregarDadosDoXml();

            int id = ObterUltimoId() + 1;

            var jogo = new Jogo(id, titulo, preco, categoria, disponibilidade);

            dadosDoArquivoXml.Add(Util.ConverterJogoParaXElement(jogo));

            SalvarXml();
        }

        private int ObterUltimoId()
        {
            int ultimoId;

            try
            {
                ultimoId = XmlConvert.ToInt32(dadosDoArquivoXml.Elements("Jogo").Attributes().Last().Value);
            }
            catch (InvalidOperationException)
            {
                ultimoId = 0;
            }
            
            return ultimoId;
        }

        public Jogo[] PesquisarPorNome(string titulo)
        {
            List<Jogo> jogos = new List<Jogo>();

            CarregarDadosDoXml();

            XElement[] jogosPesquisados = dadosDoArquivoXml.Elements("Jogo").Where(jogo => jogo.Element("Nome").Value.Contains(titulo)).ToArray();

            foreach (XElement xmlJogo in jogosPesquisados)
            {
                Jogo jogo = Util.ConverterXElementParaJogo(xmlJogo);

                jogos.Add(jogo);
            }
            
            return jogos.ToArray();
        }

        public void AlterarJogo(Jogo jogo)
        {
            CarregarDadosDoXml();

            XElement jogoXml = dadosDoArquivoXml.Elements("Jogo").FirstOrDefault(j => XmlConvert.ToInt32(j.Attribute("id").Value) == jogo.Id);

            jogoXml.Element("Nome").SetValue(jogo.Nome);
            jogoXml.Element("Preco").SetValue(jogo.Preco);
            jogoXml.Element("Categoria").SetValue(jogo.Categoria.ToString());
            jogoXml.Element("Disponibilidade").SetValue(Convert.ToBoolean(jogo.Disponibilidade));

            SalvarXml();
        }
    }
}

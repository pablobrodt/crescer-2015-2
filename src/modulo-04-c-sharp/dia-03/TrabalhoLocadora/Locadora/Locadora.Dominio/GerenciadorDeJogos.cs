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
        Jogo jogoASerAlterado;

        public GerenciadorDeJogos()
        {
            this.jogos = new List<Jogo>();
        }

        public void InserirNovoJogo(string titulo, double preco, Categoria categoria, bool disponibilidade)
        {
            int id = ObterUltimoId() + 1;

            var jogo = new Jogo(id, titulo, preco, categoria, disponibilidade);

            XElement jogosDaBase = XElement.Load(BaseDeDados.Caminho);

            jogosDaBase.Add(jogo.ToXElement());

            jogosDaBase.Save(BaseDeDados.Caminho);
        }

        private int ObterUltimoId()
        {
            int ultimoId;

            try
            {
                ultimoId = XmlConvert.ToInt32(XElement.Load(BaseDeDados.Caminho).Elements("Jogo").Attributes().Last().Value);
            }
            catch (InvalidOperationException)
            {
                ultimoId = 0;
            }
            
            return ultimoId;
        }

        public Jogo[] PesquisarPorNome(string titulo)
        { 
            XElement[] jogosPesquisados = XElement.Load(BaseDeDados.Caminho).Elements("Jogo").Where(jogo => jogo.Element("Nome").Value.Contains(titulo)).ToArray();

            foreach (XElement jogo in jogosPesquisados)
            {
                int id = XmlConvert.ToInt32(jogo.Attribute("id").Value);

                string nome = jogo.Element("Nome").Value;

                double preco = XmlConvert.ToDouble(jogo.Element("Preco").Value);

                Categoria categoria = (Categoria)Enum.Parse(typeof(Categoria), jogo.Element("Categoria").Value, true);

                bool disponibilidade = XmlConvert.ToBoolean(jogo.Element("Disponibilidade").Value);

                var objJogo = new Jogo(id, nome, preco, categoria, disponibilidade);

                jogos.Add(objJogo);
            }
            
            return this.jogos.ToArray();
        }

        public void AlterarJogo(int id)
        {
            this.jogoASerAlterado = jogos.FirstOrDefault(jogo => jogo.Id == id);
        }
        
        public void AlterarNomeJogo(string nome)
        {
            this.jogoASerAlterado.Nome = nome;
        }

        public void AlterarPrecoJogo(double preco)
        {
            this.jogoASerAlterado.Preco = preco;
        }

        public void AlterarCategoria(Categoria categoria)
        {
            this.jogoASerAlterado.Categoria = categoria;
        }

        public void AlternarDisponibilidade()
        {
            this.jogoASerAlterado.Disponibilidade = !this.jogoASerAlterado.Disponibilidade;
        }

        public void PersistirAlteracoes()
        {
            XElement todoOArquivoXml = XElement.Load(BaseDeDados.Caminho);

            foreach (Jogo jogo in jogos)
            {
                XElement elementojogo = todoOArquivoXml.Elements("Jogo").FirstOrDefault(elemento => XmlConvert.ToInt32(elemento.Attribute("id").Value) == jogo.Id);

                elementojogo.SetElementValue("Nome", jogo.Nome);
                elementojogo.SetElementValue("Preco", jogo.Preco);
                elementojogo.SetElementValue("Categoria", jogo.Categoria.ToString());
                elementojogo.SetElementValue("Disponibilidade", jogo.Disponibilidade);
            }

            todoOArquivoXml.Save(BaseDeDados.Caminho);

            this.jogos = new List<Jogo>();
        }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class BaseDeDados
    {
        private const string CAMINHO_XML = @"C:\Temp\game_store.xml";

        public IList<Jogo> BuscarTodos()
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXML().Elements("jogo");
            return ConverterListaXmlEmEntidades(dbJogos);
        }

        public void CadastrarNovoJogo(Jogo jogo)
        {
            int novoId = BuscarUltimoIdInserido() + 1;
            jogo.Id = novoId;

            XElement jogoXml = ConverterJogoEmXml(jogo);
            XElement db = CarregarBaseXML();
            db.Add(jogoXml);

            SalvarNaBaseXML(db);
        }

        public void AtualizarJogo(Jogo jogo)
        {
            string idBusca = jogo.Id.ToString();
            XElement db = CarregarBaseXML();
            XElement jogoSalvo = db.Elements("jogo")
                                   .First(j => j.Attribute("id").Value == idBusca);

            jogoSalvo.SetElementValue("nome", jogo.Nome);
            jogoSalvo.SetElementValue("preco", jogo.Preco);
            jogoSalvo.SetElementValue("categoria", jogo.Categoria.ToString());

            SalvarNaBaseXML(db);
        }

        public void ExcluirJogo(int idJogo)
        {
            XElement dbJogos = CarregarBaseXML();
            string idComparar = idJogo.ToString();
            XElement jogoASerExcluido = dbJogos.Elements("jogo").First(jogo => jogo.Attribute("id").Value == idComparar);
            jogoASerExcluido.Remove();

            SalvarNaBaseXML(dbJogos);
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXML().Elements("jogo");

            dbJogos = dbJogos.Where(jogo => jogo.Element("nome").Value.IndexOf(nome, StringComparison.InvariantCultureIgnoreCase) >= 0);

            return ConverterListaXmlEmEntidades(dbJogos);
        }

        public Jogo BuscarPorId(int idJogo)
        {
            string idComparar = idJogo.ToString();
            IEnumerable<XElement> dbJogos = CarregarBaseXML().Elements("jogo");
            return dbJogos.Where(j => j.Attribute("id").Value == idComparar)
                          .Select(j => ConverterXMLEmJogo(j))
                          .FirstOrDefault();
        }

        private int BuscarUltimoIdInserido()
        {
            IEnumerable<XElement> dbJogos = CarregarBaseXML().Elements("jogo");

            if (dbJogos.Count() < 1)
            {
                return 0;
            }

            return Convert.ToInt32(dbJogos.Last().Attribute("id").Value);
        }

        private IList<Jogo> ConverterListaXmlEmEntidades(IEnumerable<XElement> jogosXml)
        {
            return jogosXml.Select(jogo => (ConverterXMLEmJogo(jogo)))
                           .ToList();
        }

        private XElement ConverterJogoEmXml(Jogo jogo)
        {
            XElement jogoXml = new XElement("jogo");
            jogoXml.SetAttributeValue("id", jogo.Id);
            jogoXml.SetElementValue("nome", jogo.Nome);
            jogoXml.SetElementValue("preco", jogo.Preco);
            jogoXml.SetElementValue("categoria", jogo.Categoria.ToString());

            return jogoXml;
        }

        private Jogo ConverterXMLEmJogo(XElement jogoXml)
        {
            int id = Convert.ToInt32(jogoXml.Attribute("id").Value);
            string nome = jogoXml.Element("nome").Value;
            double preco = Convert.ToDouble(jogoXml.Element("preco").Value);
            Categoria categoria = ConverterXmlCategoriaEmEnum(jogoXml.Element("categoria"));

            return new Jogo(nome, preco, categoria)
            {
                Id = id
            };
        }

        private Categoria ConverterXmlCategoriaEmEnum(XElement categoriaXml)
        {
            string valorXml = categoriaXml.Value;
            return (Categoria)Enum.Parse(typeof(Categoria), valorXml);
        }

        private XElement CarregarBaseXML()
        {
            return XElement.Load(CAMINHO_XML);
        }

        private void SalvarNaBaseXML(XElement xml)
        {
            xml.Save(CAMINHO_XML);
        }
    }
}

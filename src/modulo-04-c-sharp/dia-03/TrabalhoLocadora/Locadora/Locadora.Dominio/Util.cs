using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Xml;
using System.Xml.Linq;

namespace Locadora.Dominio
{
    public class Util
    {
        public static XElement ConverterJogoParaXElement(Jogo jogo)
        {
            XElement elementoXml = new XElement("Jogo");

            elementoXml.SetAttributeValue("id", jogo.Id);

            XElement nome = new XElement("Nome", jogo.Nome);
            XElement preco = new XElement("Preco", jogo.Preco);
            XElement categoria = new XElement("Categoria", jogo.Categoria.ToString());
            XElement disponibilidade = new XElement("Disponibilidade", jogo.Disponibilidade);

            elementoXml.Add(nome);
            elementoXml.Add(preco);
            elementoXml.Add(categoria);
            elementoXml.Add(disponibilidade);

            return elementoXml;
        }

        public static Jogo ConverterXElementParaJogo(XElement elementoXml)
        {
            int id = XmlConvert.ToInt32(elementoXml.Attribute("id").Value);

            string nome = elementoXml.Element("Nome").Value;

            double preco = XmlConvert.ToDouble(elementoXml.Element("Preco").Value);

            Categoria categoria = (Categoria)Enum.Parse(typeof(Categoria), elementoXml.Element("Categoria").Value, true);

            bool disponibilidade = XmlConvert.ToBoolean(elementoXml.Element("Disponibilidade").Value);

            return new Jogo(id, nome, preco, categoria, disponibilidade);
        }
    }
}

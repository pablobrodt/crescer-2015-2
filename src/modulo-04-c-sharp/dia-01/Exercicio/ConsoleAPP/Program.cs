using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleAPP
{
    class Program
    {
        static void Main(string[] args)
        {
            var contato1 = new Contato("Fabricio", 12345);

            var contato2 = new Contato("Ben-hur", 54321);


            var agenda = new Agenda();

            agenda.AdicionarContato(contato1);
            agenda.AdicionarContato(contato2);

            string contatosDaAgenda = agenda.ListarContatos();

            Console.WriteLine(contatosDaAgenda);

            Console.WriteLine(agenda.ListarContatosOrdenadoPorNome());

            Console.ReadLine();
        }
    }
}

using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;

namespace Locadora.Repositorio.EF
{
    public class ClienteRepositorio : IClienteRepositorio
    {
        public IList<Cliente> BuscarPorNome(string nome)
        {
            using (var db = new BaseDeDados())
            {
                return db.Cliente.Include("JogosLocados").Where(c => c.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Cliente> BuscarTodos()
        {
            using (var db = new BaseDeDados())
            {
                return db.Cliente.Include("JogosLocados").ToList();
            }
        }

        public Cliente BuscarPorId(int id)
        {
            using (var db = new BaseDeDados())
            {
                return db.Cliente.Include("JogosLocados").FirstOrDefault(c => c.Id == id);
            }
        }
    }
}

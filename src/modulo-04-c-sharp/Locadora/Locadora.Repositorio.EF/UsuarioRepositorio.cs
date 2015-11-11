using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.Entity;

namespace Locadora.Repositorio.EF
{
    public class UsuarioRepositorio : IUsuarioRepositorio
    {
        public int Atualizar(Usuario usuario)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(usuario).State = EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public Usuario BuscarPorEmail(string email)
        {
            using (var db = new BaseDeDados())
            {
                return db.Usuario.Include("Permissoes").FirstOrDefault(u => u.Email.Equals(email));
            }
        }

        public int Criar(Usuario usuario)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(usuario).State = EntityState.Added;

                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            var usuario = new Usuario(id);

            using (var db = new BaseDeDados())
            {
                db.Entry(usuario).State = EntityState.Deleted;

                return db.SaveChanges();
            }
        }
    }
}

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
    public class JogoRepositorio : IJogoRepositorio
    {
        public int Atualizar(Jogo jogo)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(jogo).State = EntityState.Modified;

                return db.SaveChanges();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.Include("ClienteLocacao").FirstOrDefault(j => j.Id == id);
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.Include("ClienteLocacao").Where(j => j.Nome.Contains(nome)).ToList();
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (var db = new BaseDeDados())
            {
                return db.Jogo.Include("ClienteLocacao").ToList();
            }
        }

        public int Criar(Jogo jogo)
        {
            using (var db = new BaseDeDados())
            {
                db.Entry(jogo).State = EntityState.Added;

                return db.SaveChanges();
            }
        }

        public int Excluir(int id)
        {
            var jogo = new Jogo(id);

            using (var db = new BaseDeDados())
            {
                db.Entry(jogo).State = EntityState.Deleted;

                return db.SaveChanges();
            }
        }
    }
}

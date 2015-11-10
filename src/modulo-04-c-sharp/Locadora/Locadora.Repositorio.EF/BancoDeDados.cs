using Locadora.Dominio;
using Locadora.Repositorio.EF.Mapping;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    class BancoDeDados : DbContext
    {
        public BancoDeDados() : base("LOCADORA_EF")
        {
            
        }

        public DbSet<Jogo> Jogo { get; set; }
        public DbSet<Cliente> Cliente { get; set; }


        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());

            base.OnModelCreating(modelBuilder);
        }
    }
}

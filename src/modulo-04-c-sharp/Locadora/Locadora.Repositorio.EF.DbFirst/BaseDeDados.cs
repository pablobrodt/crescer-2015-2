using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.DbFirst
{
    public class BaseDeDados : DbContext
    {
        public BaseDeDados() : base("LOCADORA")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }

        public DbSet<Cliente> Cliente { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            Database.SetInitializer<BaseDeDados>(null);

            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            base.OnModelCreating(modelBuilder);
        }
    }

    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(j => j.Id);

            Property(j => j.Nome).IsRequired().HasMaxLength(250);
            Property(j => j.Preco).IsRequired();
            Property(j => j.Categoria).IsRequired();
            Property(j => j.Descricao).IsRequired().HasMaxLength(500);
            Property(j => j.Selo).IsOptional();
            Property(j => j.Imagem).IsOptional().HasMaxLength(500);
            Property(j => j.Video).IsOptional().HasMaxLength(500);

            HasRequired(p => p.ClienteLocacao).WithOptional().Map(m => m.MapKey("idClienteLocacao"));
        }
    }

    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(c => c.Id);

            Property(c => c.Nome).IsRequired().HasMaxLength(250);
        }
    }



}

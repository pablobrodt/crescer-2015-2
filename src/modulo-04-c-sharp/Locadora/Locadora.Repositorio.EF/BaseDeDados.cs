using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF
{
    public class BaseDeDados : DbContext
    {
        public BaseDeDados() : base("LOCADORA_EF")
        {

        }

        public DbSet<Jogo> Jogo { get; set; }

        public DbSet<Cliente> Cliente { get; set; }

        public DbSet<Usuario> Usuario { get; set; }

        public DbSet<Permissao> Permissao { get; set; }

        protected override void OnModelCreating(DbModelBuilder modelBuilder)
        {
            modelBuilder.Configurations.Add(new JogoMap());
            modelBuilder.Configurations.Add(new ClienteMap());
            modelBuilder.Configurations.Add(new UsuarioMap());
            modelBuilder.Configurations.Add(new PermissaoMap());
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
            Property(j => j.Categoria).IsRequired().HasColumnName("idCategoria");
            Property(j => j.Descricao).IsRequired().HasMaxLength(500);
            Property(j => j.Selo).IsOptional().HasColumnName("idSelo");
            Property(j => j.Imagem).IsOptional().HasMaxLength(500);
            Property(j => j.Video).IsOptional().HasMaxLength(500);

            HasOptional(p => p.ClienteLocacao).WithOptionalDependent().Map(m => m.MapKey("idClienteLocacao"));
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

    class UsuarioMap : EntityTypeConfiguration<Usuario>
    {
        public UsuarioMap()
        {
            ToTable("Usuario");

            HasKey(c => c.Id);

            Property(u => u.Email).IsRequired().HasMaxLength(200);
            Property(u => u.NomeCompleto).IsRequired().HasMaxLength(200);
            Property(u => u.Senha).IsRequired().HasMaxLength(256);

            HasMany(u => u.Permissoes).WithMany(p => p.Usuarios)
                                      .Map(
                                           m =>
                                           {
                                               m.ToTable("Usuario_Permissao");
                                               m.MapLeftKey("IdUsuario");
                                               m.MapRightKey("IdPermissao");
                                           }
                                      );
        }
    }

    class PermissaoMap : EntityTypeConfiguration<Permissao>
    {
        public PermissaoMap()
        {
            ToTable("Permissao");

            HasKey(p => p.Id);

            Property(p => p.Nome).IsRequired().HasMaxLength(200);
        }
    }
}


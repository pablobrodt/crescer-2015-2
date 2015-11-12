using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Maps
{
    class JogoMap : EntityTypeConfiguration<Jogo>
    {
        public JogoMap()
        {
            ToTable("Jogo");

            HasKey(j => j.Id);

            Property(j => j.Nome).IsRequired().HasMaxLength(250);
            Property(j => j.Categoria).IsRequired().HasColumnName("idCategoria");
            Property(j => j.Descricao).IsRequired().HasMaxLength(500);
            Property(j => j.Selo).IsOptional().HasColumnName("idSelo");
            Property(j => j.Imagem).IsOptional().HasMaxLength(500);
            Property(j => j.Video).IsOptional().HasMaxLength(500);
        }
    }
}

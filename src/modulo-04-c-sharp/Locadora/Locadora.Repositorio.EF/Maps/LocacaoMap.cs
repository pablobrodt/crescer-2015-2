using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Maps
{
    class LocacaoMap : EntityTypeConfiguration<Locacao>
    {
        public LocacaoMap()
        {
            ToTable("Locacao");

            HasKey(l => l.Id);

            Property(l => l.DataLocacao).IsRequired();
            Property(l => l.DataDevolucao).IsRequired();

            HasRequired(l => l.Cliente).WithOptional().Map(m => m.MapKey("idCliente"));
            HasRequired(l => l.Jogo).WithOptional().Map(m => m.MapKey("idJogo"));
        }
    }
}

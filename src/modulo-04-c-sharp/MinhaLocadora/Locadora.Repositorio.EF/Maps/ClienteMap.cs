using Locadora.Dominio;
using System;
using System.Collections.Generic;
using System.Data.Entity.ModelConfiguration;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Repositorio.EF.Maps
{
    class ClienteMap : EntityTypeConfiguration<Cliente>
    {
        public ClienteMap()
        {
            ToTable("Cliente");

            HasKey(c => c.Id);

            Property(c => c.Nome).IsRequired().HasMaxLength(250);

            HasMany(c => c.JogosLocados).WithOptional(j => j.ClienteLocacao).Map(m => m.MapKey("idClienteLocacao"));
        }
    }
}

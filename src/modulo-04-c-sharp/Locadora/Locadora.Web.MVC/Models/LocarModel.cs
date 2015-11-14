using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LocarModel
    {
        public LocarJogoModel LocarJogoModel { get; set; }

        public IList<ClienteModel> Clientes { get; set; }
    }
}
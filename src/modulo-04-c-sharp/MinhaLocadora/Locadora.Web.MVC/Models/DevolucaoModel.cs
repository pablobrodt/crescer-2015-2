using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class DevolucaoModel
    {
        public IList<LocarJogoModel> Jogos { get; set; }

        public LocarJogoModel LoacarJogoModel { get; set; }

        public int? idJogo { get; set; }
    }
}
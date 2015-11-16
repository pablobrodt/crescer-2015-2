using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace System.Web.Mvc.Html
{
    public static class PartialExtensions
    {   
        //TODO: FINALIZAR IMPLEMENTAÇÃO DA EXTENÇÃO PARA PARTIALVIEW

        public static MvcHtmlString PartialIf(this HtmlHelper helper, string partialName, string permission)
        {
            MvcHtmlString retorno = new MvcHtmlString("<br />");
            return retorno;
        }
    }
}
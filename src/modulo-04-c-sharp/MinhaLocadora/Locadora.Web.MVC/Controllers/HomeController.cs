<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Web.MVC/Controllers/HomeController.cs
﻿using Locadora.Web.MVC.Seguranca;
=======
﻿
using Locadora.Dominio;
using Locadora.Web.MVC.Seguranca;
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Web.MVC/Controllers/HomeController.cs
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.Mvc;

namespace Locadora.Web.MVC.Controllers
{
    [Autorizador]
    public class HomeController : Controller
    {
        public ActionResult Index()
        {
            return View();
        }
    }
}
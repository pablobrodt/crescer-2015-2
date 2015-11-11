using System;
using System.Collections.Generic;
using System.ComponentModel.DataAnnotations;
using System.Linq;
using System.Web;

namespace Locadora.Web.MVC.Models
{
    public class LoginModel
    {   
        [Required(ErrorMessage = "Campo Email precisa ser preenchido.")]
        [StringLength(200, ErrorMessage = "O email deve ter no máximo 200 caracteres.")]
        [RegularExpression(@"^\w+([-+.']\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$", ErrorMessage = "Email em formato inválido.")]
        public string Email { get; set; }

        [Required(ErrorMessage = "Campo Senha precisa ser preenchido.")]
        [StringLength(200, ErrorMessage = "A senha deve ter no máximo 200 caracteres.")]
        public string Senha { get; set; }
    }
}
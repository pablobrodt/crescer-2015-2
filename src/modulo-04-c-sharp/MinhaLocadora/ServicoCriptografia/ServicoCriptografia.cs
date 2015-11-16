using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio.Servicos;
using System.Security.Cryptography;

namespace Locadora.Servicos.ServicosCriptografia
{
    public class ServicoCriptografia : IServicoCriptografia
    {
        public string CriptografarSenha(string senha)
        {
            byte[] bytes = Encoding.ASCII.GetBytes(senha);

            SHA1CryptoServiceProvider sha1 = new SHA1CryptoServiceProvider();

            return BitConverter.ToString(sha1.ComputeHash(bytes));
        }
    }
}

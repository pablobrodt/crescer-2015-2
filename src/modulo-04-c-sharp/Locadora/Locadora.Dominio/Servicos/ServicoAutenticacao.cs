using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Locadora.Dominio.Servicos
{
    public class ServicoAutenticacao
    {
        IUsuarioRepositorio usuarioRepositorio;
        IServicoCriptografia servicoCriptografia;

        public ServicoAutenticacao(IUsuarioRepositorio repositorio, IServicoCriptografia criptografia)
        {
            this.usuarioRepositorio = repositorio;
            this.servicoCriptografia = criptografia;
        }

        public Usuario BuscarPorAutenticacao(string email, string senha)
        {
            Usuario usuario = this.usuarioRepositorio.BuscarPorEmail(email);

            if(usuario != null)
            {
                string senhaCriptografada = servicoCriptografia.CriptografarSenha(senha).Replace("-", "");

                if(usuario.Senha.ToUpper() != senhaCriptografada.ToUpper())
                {
                    return null;
                }
            }

            return usuario;
        }
    }
}

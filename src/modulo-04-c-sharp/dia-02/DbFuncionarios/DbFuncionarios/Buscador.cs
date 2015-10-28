using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Buscador
    {
        List<Funcionario> funcionarios;

        public Buscador()
        {
            BaseDeDados baseDeDados = new BaseDeDados();
            funcionarios = baseDeDados.Funcionarios;
        }

        //Exercício A
        public IList<Funcionario> OrdenadosPorCargo()
        {
            var query = this.funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo);

            return query.ToList();
        }

        //Exercício B
        public IList<Funcionario> BuscarPorNome(string nome)
        {
            var query = funcionarios.Where(funcionario => funcionario.Nome.ToLower().Contains(nome.ToLower()));

            return query.ToList();
        }

    }
}

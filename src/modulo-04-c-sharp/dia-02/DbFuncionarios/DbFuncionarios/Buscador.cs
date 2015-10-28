using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace DbFuncionarios
{
    public class Buscador
    {
        BaseDeDados baseDeDados;
        List<Funcionario> funcionarios;

        public Buscador()
        {
            baseDeDados = new BaseDeDados();
            funcionarios = baseDeDados.Funcionarios;
        }

        //Exercício A
        public IList<Funcionario> OrdenadosPorCargo()
        {
            var ordenados = this.funcionarios.OrderBy(funcionario => funcionario.Cargo.Titulo);

            return ordenados.ToList();
        }

        //Exercício B
    }
}

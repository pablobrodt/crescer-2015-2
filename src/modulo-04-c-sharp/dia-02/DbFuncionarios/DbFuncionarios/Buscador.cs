﻿using System;
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

        //Exercício C
        public IList<dynamic> BuscaRapida()
        {
            var query = from funcionario in funcionarios
                        select new
                        {   
                            Nome = funcionario.Nome,
                            TituloCargo = funcionario.Cargo.Titulo
                        };

            return query.ToArray();
        }

        //Exercício D
        public IList<Funcionario> BuscarPorTurno(params TurnoTrabalho[] turnos)
        {   
            var query = funcionarios.Where(funcionario => turnos.Any(turno => turno == funcionario.TurnoTrabalho));

            return query.ToList(); ;
        }

        //Exercício E
        public IList<dynamic> QtdFuncionariosPorTurno()
        {
            var manha = contarFuncionariosPorTurno(TurnoTrabalho.Manha);
            var tarde = contarFuncionariosPorTurno(TurnoTrabalho.Tarde);
            var noite = contarFuncionariosPorTurno(TurnoTrabalho.Noite);

            dynamic[] retorno = { new { Manha = manha }, new { Tarde = tarde }, new { Noite = noite } };

            return retorno;
        }

        private int contarFuncionariosPorTurno(TurnoTrabalho turno)
        {
            return funcionarios.Count(funcionario => funcionario.TurnoTrabalho == turno);
        }

        //Exercício F
        public IList<Funcionario> BuscarPorCargo(Cargo cargo)
        {
            var query = funcionarios.Where(funcionario => funcionario.Cargo.Titulo == cargo.Titulo);
            return query.ToList(); ;
        }
    }
}

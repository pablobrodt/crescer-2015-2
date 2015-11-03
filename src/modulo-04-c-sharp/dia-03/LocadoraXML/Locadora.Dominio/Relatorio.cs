using System;
using System.Collections.Generic;
using System.IO;

namespace Locadora.Dominio
{
    public class Relatorio
    {
        public void Gerar(string caminhoPastaRelatorio)
        {
            var db = new BaseDeDados();
            IList<Jogo> todosOsJogos = db.BuscarTodos();

            string caminhoRelatorio = Path.Combine(caminhoPastaRelatorio, "relatorio_jogos.txt");

            if(File.Exists(caminhoRelatorio))
            {
                File.Delete(caminhoRelatorio);
            }

            using (var writer = new StreamWriter(caminhoRelatorio))
            {
                writer.WriteLine("===== RELATÓRIO =====");
                writer.WriteLine(String.Format("{0:dd/MM/yyyy}", DateTime.Now));
                writer.WriteLine();

                foreach (Jogo jogo in todosOsJogos)
                {
                    writer.WriteLine(jogo);
                    writer.WriteLine();
                }
            }
        }
    }
}

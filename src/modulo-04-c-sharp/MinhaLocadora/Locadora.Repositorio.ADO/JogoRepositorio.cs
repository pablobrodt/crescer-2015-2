﻿using Locadora.Dominio.Repositorio;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using Locadora.Dominio;
using System.Data.SqlClient;
using System.Data;

namespace Locadora.Repositorio.ADO
{
    public class JogoRepositorio : RepositorioBase,  IJogoRepositorio
    {
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
        private const string BASE_SELECT = "SELECT Id, Nome, Preco, IdCategoria, IdClienteLocacao, Descricao, IdSelo, Imagem, Video FROM Jogo ";
=======
        private const string BASE_SELECT = " SELECT Id, Nome, Preco, IdCategoria, IdClienteLocacao, IdSelo, " +
                                                  " Descricao, Url_Imagem, Tag_Video " +
                                           " FROM Jogo ";
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs

        public int Atualizar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {                
                var sql = new StringBuilder();
                sql.Append(" UPDATE Jogo set ");
                sql.Append(" Nome = @paramNome, ");
                sql.Append(" Preco = @paramPreco, ");
                sql.Append(" IdCategoria = @paramIdCategoria, ");
                sql.Append(" IdClienteLocacao = @paramIdClienteLocacao, ");
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                sql.Append(" Descricao = @paramDescricao, ");
                sql.Append(" IdSelo = @paramIdSelo, ");
                sql.Append(" Imagem = @paramImagem, ");
                sql.Append(" Video = @paramVideo ");
=======
                sql.Append(" IdSelo = @paramIdSelo, ");
                sql.Append(" Descricao = @paramDescricao, ");
                sql.Append(" Url_Imagem = @paramUrlImagem, ");
                sql.Append(" Tag_Video = @paramTagVideo ");
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                sql.Append(" WHERE Id = @paramId ");

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramIdCategoria", (int)entidade.Categoria);
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                comando.AddParam("paramIdClienteLocacao", entidade.ClienteLocacao.Id);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramImagem", entidade.Imagem);
                comando.AddParam("paramVideo", entidade.Video);
=======
                comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramUrlImagem", entidade.UrlImagem);
                comando.AddParam("paramTagVideo", entidade.TagVideo);
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                comando.AddParam("paramId", entidade.Id);

                conexao.Open();

                return comando.ExecuteNonQuery();
            }
        }

        public Jogo BuscarPorId(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader).FirstOrDefault();
            }
        }

        public IList<Jogo> BuscarPorNome(string nome)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT + " WHERE Nome like @paramNome";
                comando.AddParam("paramNome", String.Format("%{0}%", nome));

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public IList<Jogo> BuscarTodos()
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = BASE_SELECT;

                conexao.Open();
                IDataReader reader = comando.ExecuteReader();

                return LerJogosDoDataReader(reader);
            }
        }

        public int Criar(Jogo entidade)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                var sql = new StringBuilder();
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                sql.Append(" INSERT INTO Jogo (Nome, Preco, IdCategoria, IdClienteLocacao, Descricao, IdSelo, Imagem, Video) ");
                sql.Append(" VALUES (@paramNome, @paramIdCategoria, @paramIdClienteLocacao, @paramDescricao, @paramIdSelo, @paramImagem, @paramVideo) ");
=======
                sql.Append(" INSERT INTO Jogo (Nome, Preco, Categoria, IdClienteLocacao, IdSelo, Descricao, Url_Imagem, Tag_Video) ");
                sql.Append(" VALUES (@paramNome, @paramPreco, @paramCategoria, @paramIdClienteLocacao, @paramIdSelo, @paramDescricao, @paramUrlImagem, @paramTagVideo) ");
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs

                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = sql.ToString();
                comando.AddParam("paramNome", entidade.Nome);
                comando.AddParam("paramIdCategoria", (int)entidade.Categoria);
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
                comando.AddParam("paramIdClienteLocacao", entidade.ClienteLocacao.Id);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramImagem", entidade.Imagem);
                comando.AddParam("paramVideo", entidade.Video);
=======
                comando.AddParam("paramIdClienteLocacao", entidade.IdClienteLocacao);
                comando.AddParam("paramIdSelo", (int)entidade.Selo);
                comando.AddParam("paramDescricao", entidade.Descricao);
                comando.AddParam("paramUrlImagem", entidade.UrlImagem);
                comando.AddParam("paramTag_Video", entidade.TagVideo);
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        public int Excluir(int id)
        {
            using (IDbConnection conexao = CriarConexao())
            {
                IDbCommand comando = conexao.CreateCommand();
                comando.CommandText = "DELETE FROM Jogos WHERE Id = @paramId";
                comando.AddParam("paramId", id);

                conexao.Open();
                return comando.ExecuteNonQuery();
            }
        }

        private IList<Jogo> LerJogosDoDataReader(IDataReader reader)
        {
            IList<Jogo> jogosLidos = new List<Jogo>();

            while (reader.Read())
            {
                jogosLidos.Add(ConverterDataReaderEmJogo(reader));
            }

            return jogosLidos;
        }

        private Jogo ConverterDataReaderEmJogo(IDataReader reader)
        {
            var jogo = new Jogo(
                id: Convert.ToInt32(reader["Id"]),
                clienteLocacao: new Cliente( (int)reader["IdClienteLocacao"].ToString().ToNullable<int>())
                );

            jogo.Nome = reader["Nome"].ToString();
            jogo.Categoria = (Categoria)Convert.ToInt32(reader["IdCategoria"]);
<<<<<<< HEAD:src/modulo-04-c-sharp/MinhaLocadora/Locadora.Repositorio.ADO/JogoRepositorio.cs
            jogo.Descricao = reader["Descricao"].ToString();
            jogo.Selo = ((Selo)Convert.ToInt32(reader["IdSelo"]));
            jogo.Imagem = reader["Imagem"].ToString();
            jogo.Video = reader["Video"].ToString();
=======
            jogo.Selo = (Selo)Convert.ToInt32(reader["IdSelo"]);
            jogo.Descricao = reader["Descricao"].ToString();
            jogo.UrlImagem = reader["Url_Imagem"].ToString();
            jogo.TagVideo = reader["Tag_Video"].ToString();
>>>>>>> 8980eb81f849470e6a5433747236b8a3a82bdc8a:src/modulo-04-c-sharp/Locadora/Locadora.Repositorio.ADO/JogoRepositorio.cs

            return jogo;
        }

    }
}

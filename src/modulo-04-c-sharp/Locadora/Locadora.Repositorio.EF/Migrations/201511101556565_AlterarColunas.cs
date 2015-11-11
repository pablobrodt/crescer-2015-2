namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlterarColunas : DbMigration
    {
        public override void Up()
        {
            RenameColumn(table: "dbo.Jogo", name: "Categoria", newName: "idCategoria");
            RenameColumn(table: "dbo.Jogo", name: "Selo", newName: "idSelo");
        }
        
        public override void Down()
        {
            RenameColumn(table: "dbo.Jogo", name: "idSelo", newName: "Selo");
            RenameColumn(table: "dbo.Jogo", name: "idCategoria", newName: "Categoria");
        }
    }
}

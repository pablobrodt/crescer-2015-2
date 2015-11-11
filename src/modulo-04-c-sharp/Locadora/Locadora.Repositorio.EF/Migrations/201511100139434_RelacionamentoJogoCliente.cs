namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RelacionamentoJogoCliente : DbMigration
    {
        public override void Up()
        {
            DropIndex("dbo.Jogo", new[] { "idClienteLocacao" });
            RenameColumn(table: "dbo.Jogo", name: "idClienteLocacao", newName: "ClienteLocacao_Id");
            AlterColumn("dbo.Jogo", "ClienteLocacao_Id", c => c.Int());
            CreateIndex("dbo.Jogo", "ClienteLocacao_Id");
        }
        
        public override void Down()
        {
            DropIndex("dbo.Jogo", new[] { "ClienteLocacao_Id" });
            AlterColumn("dbo.Jogo", "ClienteLocacao_Id", c => c.Int(nullable: false));
            RenameColumn(table: "dbo.Jogo", name: "ClienteLocacao_Id", newName: "idClienteLocacao");
            CreateIndex("dbo.Jogo", "idClienteLocacao");
        }
    }
}

namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RemoverEntidadeLocacao : DbMigration
    {
        public override void Up()
        {
            DropForeignKey("dbo.Locacao", "idCliente", "dbo.Cliente");
            DropForeignKey("dbo.Locacao", "idJogo", "dbo.Jogo");
            DropIndex("dbo.Locacao", new[] { "idCliente" });
            DropIndex("dbo.Locacao", new[] { "idJogo" });
            AddColumn("dbo.Jogo", "DataLocacao", c => c.DateTime());
            DropTable("dbo.Locacao");
        }
        
        public override void Down()
        {
            CreateTable(
                "dbo.Locacao",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        DataLocacao = c.DateTime(nullable: false),
                        DataDevolucao = c.DateTime(nullable: false),
                        idCliente = c.Int(nullable: false),
                        idJogo = c.Int(nullable: false),
                    })
                .PrimaryKey(t => t.Id);
            
            DropColumn("dbo.Jogo", "DataLocacao");
            CreateIndex("dbo.Locacao", "idJogo");
            CreateIndex("dbo.Locacao", "idCliente");
            AddForeignKey("dbo.Locacao", "idJogo", "dbo.Jogo", "Id");
            AddForeignKey("dbo.Locacao", "idCliente", "dbo.Cliente", "Id");
        }
    }
}

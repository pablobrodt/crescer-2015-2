namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AdicionarEntidadeLocacao : DbMigration
    {
        public override void Up()
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
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.idCliente)
                .ForeignKey("dbo.Jogo", t => t.idJogo)
                .Index(t => t.idCliente)
                .Index(t => t.idJogo);
            
        }
        
        public override void Down()
        {
            DropForeignKey("dbo.Locacao", "idJogo", "dbo.Jogo");
            DropForeignKey("dbo.Locacao", "idCliente", "dbo.Cliente");
            DropIndex("dbo.Locacao", new[] { "idJogo" });
            DropIndex("dbo.Locacao", new[] { "idCliente" });
            DropTable("dbo.Locacao");
        }
    }
}

namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class RelacionamentoJogoCliente : DbMigration
    {
        public override void Up()
        {
            DropIndex("dbo.Jogo", new[] { "idClienteLocacao" });
            AddColumn("dbo.Cliente", "idClienteLocacao", c => c.Int(nullable: false));
            CreateIndex("dbo.Cliente", "idClienteLocacao");
            DropColumn("dbo.Jogo", "idClienteLocacao");
        }
        
        public override void Down()
        {
            AddColumn("dbo.Jogo", "idClienteLocacao", c => c.Int(nullable: false));
            DropIndex("dbo.Cliente", new[] { "idClienteLocacao" });
            DropColumn("dbo.Cliente", "idClienteLocacao");
            CreateIndex("dbo.Jogo", "idClienteLocacao");
        }
    }
}

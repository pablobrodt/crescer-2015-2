namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class AlteracaoUsuario : DbMigration
    {
        public override void Up()
        {
            DropIndex("dbo.Usuario", "IX_UserName");
            DropColumn("dbo.Usuario", "UserName");
            AddColumn("dbo.Usuario", "Email", c => c.String(nullable: false, maxLength: 200));
            CreateIndex("dbo.Usuario", "Email", true);
        }
        
        public override void Down()
        {
            DropIndex("dbo.Usuario", "IX_Email");
            DropColumn("dbo.Usuario", "Email");
            AddColumn("dbo.Usuario", "UserName", c => c.String(nullable: false, maxLength: 200));
            CreateIndex("dbo.Usuario", "UserName", true);
        }
    }
}

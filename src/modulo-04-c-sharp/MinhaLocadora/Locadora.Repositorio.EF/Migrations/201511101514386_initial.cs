namespace Locadora.Repositorio.EF.Migrations
{
    using System;
    using System.Data.Entity.Migrations;
    
    public partial class initial : DbMigration
    {
        public override void Up()
        {
            CreateTable(
                "dbo.Cliente",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                    })
                .PrimaryKey(t => t.Id);
            
            CreateTable(
                "dbo.Jogo",
                c => new
                    {
                        Id = c.Int(nullable: false, identity: true),
                        Nome = c.String(nullable: false, maxLength: 250),
                        Preco = c.Decimal(nullable: false, precision: 18, scale: 2),
                        Categoria = c.Int(nullable: false),
                        Descricao = c.String(nullable: false, maxLength: 500),
                        Selo = c.Int(),
                        Imagem = c.String(maxLength: 500),
                        Video = c.String(maxLength: 500),
                        idClienteLocacao = c.Int(),
                    })
                .PrimaryKey(t => t.Id)
                .ForeignKey("dbo.Cliente", t => t.idClienteLocacao)
                .ForeignKey("dbo.Categoria", t => t.Categoria)
                .ForeignKey("dbo.Selo", t => t.Selo)
                .Index(t => t.idClienteLocacao);

           CreateTable(
                "dbo.Categoria",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 200)
                })
                .PrimaryKey(t => t.Id);

            CreateTable(
                "dbo.Selo",
                c => new
                {
                    Id = c.Int(nullable: false, identity: false),
                    Descricao = c.String(nullable: false, maxLength: 200)
                })
                .PrimaryKey(t => t.Id);

            Sql("INSERT INTO Categoria (Id, Descricao) VALUES (1, 'RPG')");
            Sql("INSERT INTO Categoria (Id, Descricao) VALUES (2, 'CORRIDA')");
            Sql("INSERT INTO Categoria (Id, Descricao) VALUES (3, 'AVENTURA')");
            Sql("INSERT INTO Categoria (Id, Descricao) VALUES (4, 'LUTA')");
            Sql("INSERT INTO Categoria (Id, Descricao) VALUES (5, 'ESPORTE')");

            Sql("INSERT INTO Selo (Id, Descricao) VALUES (1, 'OURO')");
            Sql("INSERT INTO Selo (Id, Descricao) VALUES (2, 'PRATA')");
            Sql("INSERT INTO Selo (Id, Descricao) VALUES (3, 'BRONZE')");

        }

        public override void Down()
        {
            DropForeignKey("dbo.Jogo", "idClienteLocacao", "dbo.Cliente");
            DropForeignKey("dbo.Jogo", "Categoria", "dbo.Categoria");
            DropForeignKey("dbo.Jogo", "Selo", "dbo.Selo");
            DropIndex("dbo.Jogo", new[] { "idClienteLocacao" });
            DropTable("dbo.Jogo");
            DropTable("dbo.Cliente");
            DropTable("dbo.Categoria");
            DropTable("dbo.Selo");
}
    }
}

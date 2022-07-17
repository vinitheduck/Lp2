package br.ufrn.imd;

public class Main {
    public static void main(String[] args) {

        System.out.println("\n" + "================================================" + "\n");

        Marketplace marketplace = new Marketplace();
        System.out.println("Testando cadastro 1: " + marketplace.cadastro("Vini", "vini_teodosio@hotmail.com", "123456"));
        System.out.println("Testando cadastro 2: " + marketplace.cadastro("Luiza", "luiza@outlook.com", "123456"));
        System.out.println("Testando cadastro 3: " + marketplace.cadastro("Luiza", "vini_teodosio@hotmail.com", "123456"));

        System.out.println("\n" + "================================================" + "\n");

        System.out.println("Usuários cadastrados: " + "\n" + marketplace.usuarios);

        System.out.println("\n" + "================================================" + "\n");

        String token_do_vini = marketplace.login("vini_teodosio@hotmail.com", "123456");
        String token_da_luiza = marketplace.login("luiza@outlook.com", "123456");

        System.out.println("Testando token do Vini: " + token_do_vini);
        System.out.println("Testando token da Luiza: " + token_da_luiza);

// até aqui está tudo ok!

        System.out.println("\n" + "================================================" + "\n");

        System.out.println("Teste:");
        int loja_do_vini = marketplace.criarLoja(token_do_vini, "Loja do Vini");
        int loja_da_Luiza = marketplace.criarLoja(token_da_luiza, "Loja da Luiza");

        System.out.println("ID loja_do_vini: " + loja_do_vini);
        System.out.println("ID loja_da_luiza: " + loja_da_Luiza);

        System.out.println("\n" + "================================================" + "\n");


// OK!
        System.out.println("Teste produtos:");

        Produtos produto_vini = new Produtos();
        Produtos produto_luiza = new Produtos();

        System.out.println("ID pao: " + produto_vini.adicionar_produto(token_do_vini, loja_do_vini, "pao", 1.00, 2));
        System.out.println("ID x-bacon: " + produto_vini.adicionar_produto(token_do_vini, loja_do_vini, "x-bacon", 4.00, 2));
        System.out.println("ID mortadela: " + produto_luiza.adicionar_produto(token_da_luiza, loja_da_Luiza, "mortadela", 1.00, 2));


        produto_vini.show_produtos(loja_do_vini);
        produto_luiza.show_produtos(loja_da_Luiza);


        System.out.println("\n" + "================================================" + "\n");

        System.out.println(produto_vini.buscar_produtos("pao", loja_do_vini));

        System.out.println("\n" + "================================================" + "\n");




        System.out.println("\n" + "================================================" + "\n");



    }
}

package br.ufrn.imd;

public class Vendas {

    int id = 0;
    int comprador_id = 0;
    int loja_id;
    int produto_id;
    int quantidade_id;
    double price;


    public int comprar_produto(String token, int protudo_id, int quantidade, int loja_id){
        if(funcMarketplace.acessosLiberados.containsKey(token)){
            Vendas venda = new Vendas();
            Loja loja = funcMarketplace.lojas.get(loja_id);
            Produtos produto = loja.produtos.get(produto_id);
            if(produto.getQuantidade() >= quantidade){
                venda.id++;
                this.id = venda.id;
                venda.comprador_id++;
                this.comprador_id= venda.comprador_id;
                Integer venda_qtd = produto.getQuantidade() - quantidade;
                produto.setQuantidade(venda_qtd);
                System.out.println(produto);

                return venda.id;
            }
            else{
                System.out.println("Produto indisponível");
            }
            System.out.println(produto);

        }

        return 0;
    }


}

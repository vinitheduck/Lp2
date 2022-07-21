package br.ufrn.imd;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Produtos{

    private int id = 0;
    private String name;
    private Double price;
    private int quantidade;
    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setPrice(Double price){
        this.price = price;
    }
    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }
    public int getQuantidade() {
        return quantidade;
    }


    public int adicionar_produto(String token, int loja_id, String name, Double price, int quantidade){
        if(funcMarketplace.acessosLiberados.containsKey(token)){
            this.id++;
            Produtos novo_produto = new Produtos();
            novo_produto.setName(name);
            novo_produto.setPrice(price);
            novo_produto.setId(this.id);
            novo_produto.setQuantidade(quantidade);
            Loja loja = funcMarketplace.lojas.get(loja_id);
            loja.produtos.add(novo_produto);
            return novo_produto.id;
        }
        else{
            return -1;
        }

    }

    public List<Produtos> buscar_produtos(String name, int loja_id){
        Loja loja = funcMarketplace.lojas.get(loja_id);
        List<Produtos> encontrados = loja.produtos.stream().filter(x->x.getName().equals(name)).collect(Collectors.toList());
        return encontrados;
    }

    public int adicionar_estoque(String token, int loja_id, int produto_id, int quantidade){
        if(funcMarketplace.acessosLiberados.containsKey(token)){
            Loja loja = funcMarketplace.lojas.get(loja_id);
            Produtos produto = loja.produtos.get(produto_id - 1);
            produto.setQuantidade(quantidade + produto.getQuantidade());
            int qtd_final = produto.getQuantidade();
            return qtd_final;
        }
        else{
            return -1;
        }
    }

    public void show_produtos(int loja_id){
        Loja loja = funcMarketplace.lojas.get(loja_id);
        System.out.println(loja.produtos);
    }

    @Override
    public String toString() {
        return "Produtos{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantidade=" + quantidade +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produtos produtos = (Produtos) o;
        return Objects.equals(name, produtos.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }


}

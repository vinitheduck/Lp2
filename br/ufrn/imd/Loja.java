package br.ufrn.imd;
import java.util.*;
import java.util.stream.Collectors;

public class Loja {
    private String name;
    private int id;
    public List<Produtos> produtos = new ArrayList<>();

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


    public List<Loja> buscar_loja(String name) {
        List<Loja> busca = new ArrayList<>(funcMarketplace.lojas.values());
        busca.stream().filter(x->x.getName().equals(name)).forEach(System.out::println);;
        return busca;
    }

    @Override
    public String toString() {
        return "Loja{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", produtos=" + produtos +
                '}' + "\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loja loja = (Loja) o;
        return Objects.equals(name, loja.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}

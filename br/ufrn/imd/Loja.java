package br.ufrn.imd;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Loja {
    private String name;
    private int id;
    List<Produtos> produtos = new ArrayList<>();

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

    @Override
    public String toString() {
        return "Loja{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", produtos=" + produtos +
                '}' + "\n";
    }


}

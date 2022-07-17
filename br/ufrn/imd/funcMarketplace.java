package br.ufrn.imd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface funcMarketplace {

    Map<String, Usuario> usuarios = new HashMap<>();
    Map<String, Integer> acessosLiberados = new HashMap<>();
    Map<Integer, Loja> lojas  = new HashMap<>();
 //   public List<Vendas> vendas = new ArrayList<>();

    boolean cadastro(String name, String email, String senha);
    String login(String email, String senha);

    int criarLoja(String token, String name);

}

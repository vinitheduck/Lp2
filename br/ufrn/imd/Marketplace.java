package br.ufrn.imd;

import javax.naming.Name;
import java.util.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class Marketplace implements funcMarketplace{
    public int user_id = 0;
    public int store_id = 0;

    public boolean cadastro(String name, String email, String senha){
        if(usuarios.containsKey(email)) {
            System.out.println("Usuário já cadastrado");
            return false;
        }
        else{
            Usuario usuario = new Usuario();
            user_id++;
            usuario.setId(user_id);
            usuario.setEmail(email);
            usuario.setName(name);
            usuario.setSenha(senha);
            usuarios.put(usuario.getEmail(), usuario);
            return true;
        }
   }
    public String login(String email, String senha) {
        if (!usuarios.containsKey(email)) {
            return "user invalid";
        } else {
            Usuario user = usuarios.get(email);
            Criptografia criptografia = new CriptografiaMD5();
            String senhaCripto = criptografia.criptografar(senha);
            if (user.getSenha().equals(senha)) {
                user.setSenha(senhaCripto);
                String token_de_acesso = RandomString.getAlphaNumericString(32);
                acessosLiberados.put(token_de_acesso, user.getId());
                return token_de_acesso;
            }
        }
        return "incorrect password";
    }
    public int criarLoja(String token, String name){
       if (acessosLiberados.containsKey(token)){
            Loja nova_loja = new Loja();
            nova_loja.setName(name);
            store_id++;
            nova_loja.setId(store_id);
            lojas.put(nova_loja.getId(), nova_loja);
            return nova_loja.getId();

        }
        else{
            System.out.println("Usuário não cadastro");
            return -1;
        }


    }

    public void logoff(String token){

        if(acessosLiberados.containsKey(token)){
            acessosLiberados.remove(token);

        }
        else {
            System.out.println("invalid");
        }

    }

}


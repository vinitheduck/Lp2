package br.ufrn.imd;

public class Usuario{
    private String name;
    private Integer id = 0;
    private String email;
    private String senha;

    public void setId(int id){
        this.id = id;
    }

    public void setName(String name){
        this.name = name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setSenha(String senha){
        this.senha = senha;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public String getEmail(){
        return email;
    }

    public String getSenha(){
        return senha;
    }


    @Override
    public String toString() {
        return "Usuario: " +
                "name = '" + name + '\'' +
                ", id = " + id +
                ", email = '" + email + '\'' +
                ", senha = '" + senha + '\'' +
                '}' + "\n";
    }



}

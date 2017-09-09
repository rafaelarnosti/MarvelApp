package com.rafaelarnosti.marvelapp.Model;

/**
 * Created by rafae on 27/08/2017.
 */

public class User {
    private String usuario;
    private String senha;
    private int avatar;

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }
}

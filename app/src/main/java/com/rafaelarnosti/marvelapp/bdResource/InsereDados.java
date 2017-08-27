package com.rafaelarnosti.marvelapp.bdResource;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by rafae on 27/08/2017.
 */

public class InsereDados {

    private SQLiteDatabase db;
    private  bdController banco;

    public InsereDados(Context context){
        banco = new bdController(context);
    }

    public String insereDado(String usuario, String senha){
        ContentValues valores;
        long resultado;

        db = banco.getWritableDatabase();
        valores = new ContentValues();
        valores.put(bdController.USUARIO, usuario);
        valores.put(bdController.SENHA, senha);

        resultado = db.insert(bdController.TABELA, null, valores);
        db.close();

        if (resultado ==-1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";

    }
}
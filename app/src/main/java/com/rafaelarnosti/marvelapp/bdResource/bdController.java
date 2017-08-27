package com.rafaelarnosti.marvelapp.bdResource;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rafae on 27/08/2017.
 */

public class bdController extends SQLiteOpenHelper {
    private static final String NOME_BANCO = "user.db";
    public static final String TABELA = "usuarios";
    private static final String ID = "_id";
    public static final String USUARIO = "usuario";
    public static final String SENHA = "senha";
    private static final int VERSAO = 1;

    public bdController(Context context){
        super(context, NOME_BANCO,null,VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABELA+"("
                + ID + " integer primary key autoincrement,"
                + USUARIO + " text,"
                + SENHA + " text"
                +" )";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS" + TABELA);
        onCreate(db);
    }
}
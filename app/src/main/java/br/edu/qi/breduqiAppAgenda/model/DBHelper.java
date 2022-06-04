package br.edu.qi.breduqiAppAgenda.model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="DBAgenda.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CREATE_TABLE_AGENDA="CREATE TABLE AGENDA(ID INTEGER NOT NULL " +
            " PRIMARY KEY AUTOINCREMENT, NOME TEXT NOT NULL, TELEFONE TEXT NOT NULL)";

    public DBHelper (@Nullable Context ctx) {
        super(ctx, DATABASE_NAME, null , DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_AGENDA);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}

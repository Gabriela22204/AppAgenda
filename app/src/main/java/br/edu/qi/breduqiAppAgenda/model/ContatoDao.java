package br.edu.qi.breduqiAppAgenda.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

public class ContatoDao {
    private static String TABLE_agenda = "AGENDA";
    private DBGateway dbG;

    public ContatoDao(Context ctx) {
        this.dbG = DBGateway.getInstance(ctx);

    }

    public boolean update(Contato contato) {

        if (!isExist(contato.getId()))
            return false;

        ContentValues cv = new ContentValues();

        cv.put("NOME", contato.getNome());
        cv.put("TELEFONE", contato.getTelefone());

        return this.dbG.getDatabase().update(TABLE_agenda, cv, "ID=?", new String[] {contato.getId()+""}) > 0 ;

    }

    public boolean delete(int id) {
        if (!isExist(id))
            return false;

        return this.dbG.getDatabase().delete(TABLE_agenda, "ID=?" , new String[] {id+""})  > 0 ;
    }

    public boolean isExist(int id) {
        Cursor cursor = dbG.getDatabase().rawQuery("SELECT * FROM AGENDA WHERE ID=" +id, null);

        return cursor.moveToFirst();
    }

    public  boolean save(Contato contato) {
        ContentValues cv = new ContentValues();

        cv.put("NOME", contato.getNome());
        cv.put("TELEFONE", contato.getTelefone());

        return this.dbG.getDatabase().insert(TABLE_agenda, null, cv) > 0 ;

    }
}
